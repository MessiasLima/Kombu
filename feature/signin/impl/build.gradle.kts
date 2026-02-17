plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

ext {
    set("namespace", "dev.appoutlet.kombu.feature.signin.impl")
}

apply(from = "$rootDir/gradle/script/feature-impl.gradle")

dependencies {
    commonMainApi(project(":feature:signin"))
    commonMainImplementation(project(":feature:main"))
}
