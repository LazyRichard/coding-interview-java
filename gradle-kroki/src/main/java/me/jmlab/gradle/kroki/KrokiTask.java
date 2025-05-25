package me.jmlab.gradle.kroki;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;
import javax.inject.Inject;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.file.FileType;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.SkipWhenEmpty;
import org.gradle.api.tasks.TaskAction;
import org.gradle.work.ChangeType;
import org.gradle.work.FileChange;
import org.gradle.work.InputChanges;
import org.gradle.workers.WorkerExecutor;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public abstract class KrokiTask extends DefaultTask {

    private final WorkerExecutor executor;

    @SkipWhenEmpty
    @InputDirectory
    @PathSensitive(PathSensitivity.RELATIVE)
    public abstract DirectoryProperty getSourceDirectory();

    @Input
    public abstract Property<URI> getUri();

    @Input
    public abstract MapProperty<String, String> getHeaders();

    @OutputDirectory
    public abstract DirectoryProperty getOutputDirectory();

    @Input
    @Optional
    public abstract Property<Integer> getBatchSize();

    @Inject
    public KrokiTask(WorkerExecutor executor) {
        this.executor = executor;
    }

    @TaskAction
    public void action(InputChanges changes) {
        var extension = getProject().getExtensions().getByType(KrokiExtension.class);

        Map<String, String> extensionMap = new HashMap<>();
        extension.getDiagramConfigurations().forEach(configuration -> {
            if (configuration.getEnabled().get()) {
                configuration.getExtensionMappings().get().forEach(el -> extensionMap.put(el, configuration.getName()));
            }
        });

        var queue = executor.classLoaderIsolation();

        List<FileChange> fileChanges = StreamSupport.stream(changes.getFileChanges(getSourceDirectory()).spliterator(), false)
                .filter(p -> p.getFileType() != FileType.DIRECTORY)
                .filter(p -> p.getChangeType() != ChangeType.REMOVED)
                .toList();

        BatchIterable<FileChange> batchIter = new BatchIterable<>(
            fileChanges.iterator(),
            getBatchSize().orElse(10).get());

        for (List<FileChange> batch: batchIter) {
            for (FileChange change: batch) {
                String filename = change.getFile().getName();

                Map.Entry<String, String> extracted = extractFileExtension(filename, 1);
                if (extracted == null) {
                    getProject().getLogger().warn("failed to extract extension from file {}", filename);
                    return;
                }

                String lang = extensionMap.get("." + extracted.getValue());
                if (lang == null) {
                    getProject()
                        .getLogger()
                        .warn(
                            "failed to find extension for file {} in extension map {}",
                            filename,
                            extracted.getValue());
                    return;
                }

                String format;
                if (extension
                    .getDiagramConfigurations()
                    .getByName(lang)
                    .getFormat()
                    .isPresent())
                    format = extension
                        .getDiagramConfigurations()
                        .getByName(lang)
                        .getFormat()
                        .get();
                else format = "svg";

                var relativeOutput = getSourceDirectory()
                    .getAsFile()
                    .map(File::toPath)
                    .map(m -> {
                        Path parent =
                            m.relativize(change.getFile().toPath()).getParent();

                        File file;
                        if (parent == null)
                            file = getOutputDirectory().getAsFile().get();
                        else
                            file = getOutputDirectory()
                                .getAsFile()
                                .get()
                                .toPath()
                                .resolve(parent)
                                .toFile();

                        var d = getProject().getObjects().directoryProperty();
                        d.set(file);

                        return d;
                    })
                    .get()
                    .file(extracted.getKey() + "." + format);

                var input = getProject().getObjects().fileProperty();
                input.set(change.getFile());

                queue.submit(KrokiWorkAction.class, param -> {
                    param.getUri().set(getUri());
                    param.getHeaders().set(getHeaders());
                    param.getDiagram().set(lang);
                    param.getInput().set(input);
                    param.getFormat().set(format);
                    param.getOutput().set(relativeOutput);
                });
            }

            queue.await();
        }
    }

    private static Map.@Nullable Entry<String, String> extractFileExtension(@NonNull String fileName, int maxDepth) {
        if (fileName.isBlank()) return null;

        String[] parts = fileName.split("\\.");
        if (parts.length == 1) {
            // 확장자가 없는 경우
            return Map.entry(fileName, "");
        }

        int splitIndex = Math.max(parts.length - maxDepth, 1); // 최소 1개는 파일 이름으로 남겨둬야 함
        String baseName = String.join(".", Arrays.copyOfRange(parts, 0, splitIndex));
        String extension = String.join(".", Arrays.copyOfRange(parts, splitIndex, parts.length));

        return Map.entry(baseName, extension);
    }

    private static final class BatchIterable<T> implements Iterable<List<T>> {

        @NonNull
        private final Iterator<T> iter;

        private final int batchSize;

        public BatchIterable(@NonNull Iterator<T> iter, int batchSize) {
            this.iter = iter;
            this.batchSize = batchSize;
        }

        public BatchIterable(@NonNull Iterator<T> iter) {
            this(iter, 10);
        }

        @Override
        public @NotNull Iterator<List<T>> iterator() {
            return new BatchIterator<>(iter, batchSize);
        }
    }

    private static final class BatchIterator<T> implements Iterator<List<T>> {

        private final int batchSize;

        @NonNull
        private final Iterator<T> iter;

        public BatchIterator(@NonNull Iterator<T> iter) {
            this(iter, 10);
        }

        public BatchIterator(@NonNull Iterator<T> iter, int batchSize) {
            this.iter = iter;
            this.batchSize = batchSize;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @NonNull
        @Override
        public List<T> next() {
            List<T> current = new ArrayList<>(batchSize);
            while (iter.hasNext() && current.size() < batchSize) {
                current.add(iter.next());
            }

            return current;
        }
    }
}
