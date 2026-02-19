plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

ext {
    set("namespace", "dev.appoutlet.kombu.data.umami")
}

apply(from = "$rootDir/gradle/script/data.gradle")

dependencies {
    commonMainImplementation(libs.umami)
    commonMainApi(libs.umami.api)
}
