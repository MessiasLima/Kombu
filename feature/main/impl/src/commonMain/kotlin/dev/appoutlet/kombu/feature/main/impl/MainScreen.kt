package dev.appoutlet.kombu.feature.main.impl

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun MainScreen() {
    val navigationAggregator = koinInject<MainTabNavigationAggregator>()
    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                for (navigation in navigationAggregator.navigationList) { navigation.setupPolymorphism(this) }
            }
        }
    }
    val backStack = rememberNavBackStack(configuration = config, WebsitesDestination)

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            navigationAggregator.navigationList.forEachIndexed { index, item ->
                item(
                    selected = backStack.last() == item.key,
                    onClick = { backStack.add(item.key) },
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(stringResource(item.label)) }
                )
            }
        },
        content = {
            NavDisplay(
                backStack = backStack,
                entryProvider = entryProvider {
                    for (navigation in navigationAggregator.navigationList) { navigation.setupRoute(this) }
                },
            )
        }
    )
}
