plugins {
    id("me.jmlab.coding.test.java-library-conventions")
}

dependencies {
    implementation(platform(libs.junit.bom))
    implementation(libs.jupiter.api)
}
