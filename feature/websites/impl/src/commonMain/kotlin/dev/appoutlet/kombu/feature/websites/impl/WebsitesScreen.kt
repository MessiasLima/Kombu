package dev.appoutlet.kombu.feature.websites.impl

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import dev.appoutlet.kombu.feature.overview.OverviewDestination
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.koinInject

@Composable
fun WebsitesScreen() {
    val navigationAggregator = koinInject<WebsitesNavigationAggregator>()

    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                for (navigation in navigationAggregator.navigation) { navigation.setupPolymorphism(this) }
            }
        }
    }

    val backStack = rememberNavBackStack(configuration = config, OverviewDestination)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            for (navigation in navigationAggregator.navigation) { navigation.setupRoute(this) }
        },
    )
}
