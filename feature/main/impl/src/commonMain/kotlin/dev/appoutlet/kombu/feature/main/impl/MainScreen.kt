package dev.appoutlet.kombu.feature.main.impl

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import dev.appoutlet.kombu.core.navigation.getSavedStateConfiguration
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun MainScreen() {
    val navigationAggregator = koinInject<MainTabNavigationAggregator>()
    val config = remember(navigationAggregator) { getSavedStateConfiguration(navigationAggregator.navigation) }
    val backStack = rememberNavBackStack(configuration = config, WebsitesDestination)

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            navigationAggregator.navigation.forEach { item ->
                item(
                    selected = backStack.last() == item.key,
                    onClick = {
                        if (item.key == WebsitesDestination) {
                            backStack.clear()
                            backStack.add(item.key)
                        } else {
                            if (backStack.last() != item.key) {
                                backStack.add(item.key)
                            }
                        }
                    },
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(stringResource(item.label)) }
                )
            }
        },
        content = {
            NavDisplay(
                backStack = backStack,
                entryProvider = entryProvider {
                    for (navigation in navigationAggregator.navigation) {
                        navigation.setupRoute(this)
                    }
                },
            )
        }
    )
}
