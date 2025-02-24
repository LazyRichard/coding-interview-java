import org.gradle.api.plugins.jvm.JvmTestSuite

plugins {
    java

    `jvm-test-suite`
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.10.0")
        }
    }
}
