package dev.appoutlet.kombu.feature.websites.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import dev.appoutlet.kombu.core.navigation.getSavedStateConfiguration
import dev.appoutlet.kombu.feature.overview.OverviewDestination
import org.koin.compose.koinInject

@Composable
fun WebsitesScreen() {
    val navigationAggregator = koinInject<WebsitesNavigationAggregator>()

    val config = remember(navigationAggregator) { getSavedStateConfiguration(navigationAggregator.navigation) }
    val backStack = rememberNavBackStack(configuration = config, OverviewDestination)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            for (navigation in navigationAggregator.navigation) {
                navigation.setupRoute(this)
            }
        },
    )
}
