plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

ext {
    set("namespace", "dev.appoutlet.kombu.feature.signin.impl")
    set("apiModule", ":feature:signin")
}

apply(from = "$rootDir/gradle/script/feature-impl.gradle")

