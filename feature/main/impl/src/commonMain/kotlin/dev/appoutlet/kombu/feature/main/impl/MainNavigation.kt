package dev.appoutlet.kombu.feature.main.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.levels.AppNavigation
import dev.appoutlet.kombu.feature.main.MainDestination
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class MainNavigation : AppNavigation<MainDestination> {
    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<MainDestination> { MainScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(MainDestination::class, MainDestination.serializer())
    }
}
