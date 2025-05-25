import java.net.URI

plugins {
    id("me.jmlab.gradle.gradle-kroki")
}

kroki {
    uri.set(URI.create(project.properties["KROKI_HOST"] as String))

    if (project.hasProperty("KROKI_AUTH")) {
        headers.put("Authorization", project.properties["KROKI_AUTH"] as String)
    }
}
