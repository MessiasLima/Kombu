package dev.appoutlet.kombu

import org.koin.core.annotation.Configuration
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module
import org.koin.meta.annotations.ExternalDefinition


@Module
@Configuration
class AppModule

@KoinApplication
@ExternalDefinition("dev.appoutlet.kombu.feature")
object KombuApplication
