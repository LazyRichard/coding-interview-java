import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("me.jmlab.interview.kotlin-common-conventions")

    kotlin("plugin.spring")
    kotlin("kapt")

    id("org.springframework.boot")
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    kapt(platform(SpringBootPlugin.BOM_COORDINATES))

    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter")

    kapt("org.springframework.boot:spring-boot-autoconfigure-processor")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.mockito.kotlin:mockito-kotlin")
}

val bootRun by tasks.getting(BootRun::class) {
    enableAssertions = true

    args = listOf(
        "--spring.profiles.active=local"
    )
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages"))
}

val test by tasks.getting(Test::class) {
    jvmArgs(listOf("-XX:+ShowCodeDetailsInExceptionMessages", "-Dspring.profiles.active=test"))
}
