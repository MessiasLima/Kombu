package dev.appoutlet.kombu.feature.main.impl

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND
import dev.appoutlet.kombu.core.navigation.getSavedStateConfiguration
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun MainScreen() {
    val navigationAggregator = koinInject<MainTabNavigationAggregator>()
    val config = remember(navigationAggregator) { getSavedStateConfiguration(navigationAggregator.navigation) }
    val backStack = rememberNavBackStack(configuration = config, WebsitesDestination)
    val itemPaddingBottom by animateDpAsState(targetValue = if (isNarrowScreen()) 0.dp else 12.dp)
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            navigationAggregator.navigation.forEach { item ->
                item(
                    modifier = Modifier.padding(bottom = itemPaddingBottom),
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

@Composable
private fun isNarrowScreen(): Boolean {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    return remember(windowSizeClass) {
        windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND).not()
    }
}
