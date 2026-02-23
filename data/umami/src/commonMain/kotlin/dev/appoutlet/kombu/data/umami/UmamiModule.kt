package dev.appoutlet.kombu.data.umami

import dev.appoutlet.umami.Umami
import dev.appoutlet.umami.api.auth
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Module
@ComponentScan("dev.appoutlet.kombu.data.umami")
@Configuration
class UmamiModule {
    @OptIn(ExperimentalUuidApi::class)
    @Single
    fun provideUmami(): Umami = Umami(Uuid.random())

    @Single
    fun provideUmamiAuth(umami: Umami) = umami.auth()
}
