plugins {
    id("me.jmlab.interview.java-library-conventions")
}

dependencies {
    implementation(platform(libs.junit.bom))
    implementation(libs.jupiter.api)
}
