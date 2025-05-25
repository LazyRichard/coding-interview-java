package me.jmlab.interview.extension;

import org.jspecify.annotations.NonNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StreamUtil {

    @NonNull
    public static String readLine(@NonNull InputStream stream) {
        try (var in = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            try (var reader = new BufferedReader(in)) {
                return reader.readLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @NonNull
    public static String readText(@NonNull InputStream stream) {
        Objects.requireNonNull(stream, "stream should not be a null");

        try (var in = stream; var out = new ByteArrayOutputStream(1024)) {
            var buffer = new byte[1024];
            int nRead;

            while ((nRead = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, nRead);
            }

            return out.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void readLines(@NonNull InputStream stream,@NonNull BiConsumer<@NonNull String, @NonNull Integer> processor) {
        try (var in = new InputStreamReader(stream)) {
            try (var reader = new BufferedReader(in)) {
                String line;

                int count = 0;
                while ((line = reader.readLine()) != null) {
                    processor.accept(line, count);
                    count++;
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void readLines(@NonNull InputStream stream, @NonNull Consumer<@NonNull String> processor) {
        readLines(stream, (line, count) -> processor.accept(line));
    }

    public static void transferStream(@NonNull InputStream input,@NonNull OutputStream output) {
        try (var writer = new PrintWriter(output)) {
            try (var in = new InputStreamReader(input)) {
                try (var reader = new BufferedReader(in)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.write('\n');
                    }
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
