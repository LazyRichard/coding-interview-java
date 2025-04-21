
val docHtmlLeetcode by configurations.registering {
    isCanBeConsumed = true
    isCanBeResolved = true
}

val docHtmlCodility by configurations.registering {
    isCanBeConsumed = true
    isCanBeResolved = true
}

dependencies {
    docHtmlLeetcode(project(":leetcode", configuration = "docHtml"))
    docHtmlCodility(project(":codility", configuration = "docHtml"))
}

tasks.register("buildDocument", Copy::class) {

    group = "build"

    from(docHtmlLeetcode) {
        into ("leetcode")
    }
    from(docHtmlCodility) {
        into("codility")
    }
    from (layout.projectDirectory.dir("src/main/html"))

    into(layout.buildDirectory.dir("html"))
}
