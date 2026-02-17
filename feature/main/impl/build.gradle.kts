plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
}

ext {
    set("namespace", "dev.appoutlet.kombu.feature.main.impl")
    set("apiModule", ":feature:main")
}

apply(from = "$rootDir/gradle/script/feature-impl.gradle")

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":feature:websites"))
                implementation(project(":feature:links"))
                implementation(project(":feature:overview"))
            }
        }
    }
}
