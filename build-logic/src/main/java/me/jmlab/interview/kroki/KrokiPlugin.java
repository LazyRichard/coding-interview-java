package me.jmlab.interview.kroki;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public final class KrokiPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        var extension = project.getExtensions().create("kroki", KrokiExtension.class);

        var diagramConfigurations = extension.getDiagramConfigurations();
        diagramConfigurations.create("bpmn", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".bpmn"));
        });

        diagramConfigurations.create("dbml", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".dbml"));
        });

        diagramConfigurations.create("erd", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".erd"));
        });

        diagramConfigurations.create("excalidraw", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".excalidraw"));
        });

        diagramConfigurations.create("graphviz", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".dot"));
        });

        diagramConfigurations.create("plantuml", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".puml", ".preproc"));
        });

        diagramConfigurations.create("d2", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".d2"));
        });

        diagramConfigurations.create("gv", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".gv"));
        });

        diagramConfigurations.create("vega", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".vg"));
        });

        diagramConfigurations.create("vegalite", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".vgl", ".vl"));
        });

        diagramConfigurations.create("diagramsnet", diagram -> {
            diagram.getEnabled().convention(true);
            diagram.getExtensionMappings().convention(List.of(".drawio"));
        });

        project.getTasks().register("krokiBuild", KrokiTask.class, task -> {

            URI uri;
            Map<String, ?> properties = project.getProperties();
            if (properties.containsKey("KROKI_HOME"))
                uri = URI.create((String) properties.get("KROKI_HOME"));
            else uri = URI.create("https://kroki.io");

            task.getUri().set(extension.getUri().convention(uri));
            task.getHeaders().set(extension.getHeaders());
            task.getOutputDirectory()
                    .set(project.getLayout().getBuildDirectory().dir("diagram"));
            task.getSourceDirectory()
                    .set(project.getLayout().getProjectDirectory().dir("src/main/diagram"));
        });
    }
}
