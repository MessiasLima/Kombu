import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvm()
    sourceSets {
        jvmMain.dependencies {
            implementation(project(":app:shared"))
            implementation(compose.desktop.currentOs)
            implementation(libs.coroutines.swing)
        }
    }
}

compose.desktop {
    application {
        mainClass = "dev.appoutlet.kombu.Kombu"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "dev.appoutlet.Kombu"
            packageVersion = libs.versions.versionName.get()
        }
    }
}
