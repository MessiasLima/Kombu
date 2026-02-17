package dev.appoutlet.kombu.feature.overview.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.WebsitesNavigation
import dev.appoutlet.kombu.feature.overview.OverviewDestination
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class OverviewNavigation : WebsitesNavigation<OverviewDestination> {
    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<OverviewDestination> { OverviewScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(OverviewDestination::class, OverviewDestination.serializer())
    }
}
