package me.jmlab.interview.kroki;

import java.net.URI;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.gradle.workers.WorkParameters;

public interface KrokiWorkParameter extends WorkParameters {

    Property<URI> getUri();

    MapProperty<String, String> getHeaders();

    RegularFileProperty getInput();

    Property<String> getDiagram();

    Property<String> getFormat();

    RegularFileProperty getOutput();
}
