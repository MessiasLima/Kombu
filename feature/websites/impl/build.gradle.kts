plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

ext {
    set("namespace", "dev.appoutlet.kombu.feature.websites.impl")
}

apply(from = "$rootDir/gradle/script/feature-impl.gradle")

dependencies {
    commonMainApi(project(":feature:websites"))
    commonMainImplementation(project(":feature:overview"))
}
