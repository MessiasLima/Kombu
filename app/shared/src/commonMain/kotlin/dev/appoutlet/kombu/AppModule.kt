package dev.appoutlet.kombu

import dev.appoutlet.kombu.data.umami.UmamiModule
import dev.appoutlet.kombu.feature.links.impl.LinksModule
import dev.appoutlet.kombu.feature.main.impl.MainModule
import dev.appoutlet.kombu.feature.overview.impl.OverviewModule
import dev.appoutlet.kombu.feature.pixels.impl.PixelsModule
import dev.appoutlet.kombu.feature.settings.impl.SettingsModule
import dev.appoutlet.kombu.feature.signin.impl.SignInModule
import dev.appoutlet.kombu.feature.websites.impl.WebsitesModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module


@Module(
    includes = [
        FeatureModule::class,
        DataModule::class
    ]
)
@ComponentScan("dev.appoutlet.kombu")
class AppModule


@Module(
    includes = [
        LinksModule::class,
        MainModule::class,
        OverviewModule::class,
        PixelsModule::class,
        SettingsModule::class,
        SignInModule::class,
        WebsitesModule::class
    ]
)
class FeatureModule

@Module(
    includes = [
        UmamiModule::class
    ]
)
class DataModule
