plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.multiplatform.library) apply false
    alias(libs.plugins.buildConfig) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kover) apply false
    alias(libs.plugins.mokkery) apply false
    alias(libs.plugins.sentry) apply false

    alias(libs.plugins.gitHooks)
}
