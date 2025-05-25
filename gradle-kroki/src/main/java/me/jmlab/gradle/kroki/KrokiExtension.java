package me.jmlab.gradle.kroki;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;

import java.net.URI;

public interface KrokiExtension {

    Property<URI> getUri();

    MapProperty<String, String> getHeaders();

    NamedDomainObjectContainer<KrokiDiagramConfiguration> getDiagramConfigurations();
}
