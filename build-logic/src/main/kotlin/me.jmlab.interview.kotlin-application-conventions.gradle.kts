import org.gradle.api.tasks.JavaExec

plugins {
    id("me.jmlab.interview.kotlin-application-conventions")

    application
}

val run by tasks.getting(JavaExec::class) {
    enableAssertions = true
}
