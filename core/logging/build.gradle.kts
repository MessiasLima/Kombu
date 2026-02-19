plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

ext {
    set("namespace", "dev.appoutlet.kombu.core.logging")
}

apply(from = "$rootDir/gradle/script/core.gradle")

dependencies {
    commonMainApi(libs.kermit.core)
    commonMainImplementation(libs.kermit.koin)
    commonMainImplementation(libs.koin.core)
}
