plugins {
    `java-gradle-plugin`
}

group = "me.jmlab.gradle"

repositories {
    gradlePluginPortal()
}

dependencies {
    compileOnly("org.jspecify:jspecify:1.0.0")
}

gradlePlugin {
    plugins {
        register("kroki") {
            id = "me.jmlab.gradle.gradle-kroki"
            implementationClass = "me.jmlab.gradle.kroki.KrokiPlugin"
        }
    }
}
