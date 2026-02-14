package dev.appoutlet.kombu.feature.main

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.Navigation
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Factory

@Factory
class MainNavigation : Navigation<NavKey> {
    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<MainDestination> { MainScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(MainDestination::class, MainDestination.serializer())
    }
}

@Serializable
data object MainDestination : NavKey
