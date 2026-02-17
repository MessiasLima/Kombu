package dev.appoutlet.kombu

import dev.appoutlet.kombu.feature.signin.impl.SignInModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module


@Module(
    includes = [
        FeatureModule::class
    ]
)
@ComponentScan("dev.appoutlet.kombu")
class AppModule


@Module(
    includes = [
        SignInModule::class
    ]
)
class FeatureModule
