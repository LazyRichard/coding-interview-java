plugins {
    id("me.jmlab.interview.java-stream-test-conventions")
}

val docHtml by configurations.registering {
    isCanBeConsumed = true
    isCanBeResolved = false
}

val javadoc by tasks.getting(Javadoc::class) {
    options {
        showFromPrivate()
    }
}

artifacts {
    add(docHtml.name, javadoc.outputs.files.singleFile) {
        builtBy(javadoc)
    }
}
