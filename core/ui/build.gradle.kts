plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.multiplatform.library)
}

ext {
    set("namespace", "dev.appoutlet.kombu.core.ui")
}

apply(from = "$rootDir/gradle/script/core.gradle")

kotlin {
    android {
        androidResources {
            enable = true
        }
    }
}

dependencies {
    commonMainImplementation(project(":core:mvi"))

    // Compose
    commonMainImplementation(libs.compose.foundation)
    commonMainImplementation(libs.compose.material3)
    commonMainImplementation(libs.compose.runtime)
    commonMainImplementation(libs.compose.ui)
    commonMainImplementation(libs.compose.ui.tooling.preview)
    commonMainImplementation(libs.compose.components.resources)
    commonMainImplementation(libs.compose.components.uiToolingPreview)
    commonMainImplementation(libs.lucideIcons)
    commonMainImplementation(libs.material3.adaptive.navigation3)
}
