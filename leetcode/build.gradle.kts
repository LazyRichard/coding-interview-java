import java.net.URI

plugins {
    id("me.jmlab.interview.java-stream-test-conventions")

    id("me.jmlab.interview.kroki-conventions")
}

val docHtml by configurations.registering {
    isCanBeConsumed = true
    isCanBeResolved = false
}

val krokiBuild by tasks.getting

val javadoc by tasks.getting(Javadoc::class) {

    dependsOn(krokiBuild)

    options {
        showFromPrivate()
    }

    doLast {
        copy {
            from(krokiBuild)
            from(layout.projectDirectory.dir("src/main/assets"))
            into(layout.buildDirectory.dir("docs/javadoc/resources"))
        }
    }

    inputs.files(krokiBuild.outputs)
    inputs.dir(layout.projectDirectory.dir("src/main/assets"))
}

artifacts {
    add(docHtml.name, javadoc.outputs.files.singleFile) {
        builtBy(javadoc)
    }
}
