rootProject.name = "Kombu"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven("https://packages.jetbrains.team/maven/p/kpm/public/")
        maven("https://jogamp.org/deployment/maven")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":app:android")
include(":app:desktop")
include(":app:shared")
include(":core:logging")
include(":core:mvi")
include(":core:navigation")
include(":core:ui")
include(":data:umami")
include(":feature:links")
include(":feature:links:impl")
include(":feature:main")
include(":feature:main:impl")
include(":feature:overview")
include(":feature:overview:impl")
include(":feature:pixels")
include(":feature:pixels:impl")
include(":feature:settings")
include(":feature:settings:impl")
include(":feature:signin")
include(":feature:signin:impl")
include(":feature:websites")
include(":feature:websites:impl")
