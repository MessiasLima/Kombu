plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

ext {
    set("namespace", "dev.appoutlet.kombu.core.navigation")
}

apply(from = "$rootDir/gradle/script/core.gradle")

dependencies {
    commonMainImplementation(libs.compose.components.resources)
    commonMainImplementation(libs.navigation3.ui)
}
