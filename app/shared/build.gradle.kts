plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
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
            baseName = "Shared"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                // Project dependencies (alphabetically)
                implementation(project(":core:logging"))
                implementation(project(":core:navigation"))
                implementation(project(":feature:links:impl"))
                implementation(project(":feature:main:impl"))
                implementation(project(":feature:overview:impl"))
                implementation(project(":feature:pixels:impl"))
                implementation(project(":feature:settings:impl"))
                implementation(project(":feature:signin:impl"))
                implementation(project(":feature:websites:impl"))

                // Library dependencies (alphabetically)
                implementation(libs.compose.components.resources)
                implementation(libs.compose.components.uiToolingPreview)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.runtime)
                implementation(libs.compose.ui)
                implementation(libs.koin.annotations)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewModel)
                implementation(libs.koin.core)
                implementation(libs.lifecycle.runtimeCompose)
                implementation(libs.lifecycle.viewModel)
                implementation(libs.lucideIcons)
                implementation(libs.material3.adaptive.navigation3)
                implementation(libs.material3.adaptive.navigationSuite)
                implementation(libs.navigation3.ui)
            }

            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

// region KSP
tasks.matching { it.name.startsWith("ksp") && it.name != "kspCommonMainKotlinMetadata" }.configureEach {
    dependsOn("kspCommonMainKotlinMetadata")
}

ksp {
    arg("KOIN_DEFAULT_MODULE", "false")
    arg("KOIN_CONFIG_CHECK","false")
}

dependencies {
    // Per-platform KSP configuration required
    add("kspCommonMainMetadata", libs.koin.kspCompiler)
    add("kspAndroid", libs.koin.kspCompiler)
    add("kspIosArm64", libs.koin.kspCompiler)
    add("kspIosSimulatorArm64", libs.koin.kspCompiler)
}

// endregion
