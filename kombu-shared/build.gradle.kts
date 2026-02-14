plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
}

kotlin {
    android {
        namespace = "dev.appoutlet.kombu"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "KombuShared"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.lifecycle.viewModel)
            implementation(libs.lifecycle.runtimeCompose)
            implementation(libs.navigation3.ui)
            implementation("org.jetbrains.compose.material3.adaptive:adaptive-navigation3:1.3.0-alpha02")
            implementation("org.jetbrains.compose.material3:material3-adaptive-navigation-suite:1.10.0-alpha05")
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
