plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

ext {
    set("namespace", "dev.appoutlet.kombu.feature.main.impl")
}

apply(from = "$rootDir/gradle/script/feature-impl.gradle")

dependencies {
    commonMainApi(project(":feature:main"))
    commonMainImplementation(project(":feature:links"))
    commonMainImplementation(project(":feature:overview"))
    commonMainImplementation(project(":feature:websites"))
}
