package me.jmlab.gradle.kroki;

import org.gradle.api.Named;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.Property;

public interface KrokiDiagramConfiguration extends Named {

    Property<Boolean> getEnabled();

    ListProperty<String> getExtensionMappings();

    Property<String> getFormat();
}
