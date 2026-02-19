plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

ext {
    set("namespace", "dev.appoutlet.kombu.core.mvi")
}

apply(from = "$rootDir/gradle/script/core.gradle")

dependencies {
    commonMainApi(libs.orbit.core)
    commonMainApi(libs.orbit.compose)
    commonMainApi(libs.orbit.viewModel)
}
