plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
}

ext {
    set("namespace", "dev.appoutlet.kombu.feature.settings.impl")
    set("apiModule", ":feature:settings")
}

apply(from = "$rootDir/gradle/script/feature-impl.gradle")
