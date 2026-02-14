package dev.appoutlet.kombu.feature.main

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.scene.SceneStrategyScope
import dev.appoutlet.kombu.LocalNavigator

class NavigationSuiteBottomScene<T : Any>(
    override val key: Any,
    override val previousEntries: List<NavEntry<T>>,
    private val tabEntry: NavEntry<T>,
    private val navigationItems: Array<out NavigationItem>,
) : Scene<T> {
    override val entries: List<NavEntry<T>> = listOf(tabEntry)

    override val content: @Composable (() -> Unit) = {
        val navigator = LocalNavigator.current

        SideEffect {
            println("NavigationSuiteBottomScene SideEffect")
        }

        NavigationSuiteScaffold(
            navigationSuiteItems = {
                navigationItems.forEach {
                    item(
                        selected = navigator.backStack.last() == it.navKey,
                        onClick = { navigator.navigate(it.navKey) },
                        icon = { Icon(it.icon, contentDescription = null) },
                        label = it.label?.let { label -> { Text(label) } }
                    )
                }
            },
            content = { tabEntry.Content() }
        )
    }
}

@Composable
fun <T : Any> rememberNavigationSuiteSceneStrategy(vararg navigationItems: NavigationItem): NavigationSuiteSceneStrategy<T> {
    return remember {
        NavigationSuiteSceneStrategy(navigationItems)
    }
}

class NavigationSuiteSceneStrategy<T : Any>(
    private val navigationItems: Array<out NavigationItem>,
) : SceneStrategy<T> {
    override fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T>? {
        val tabEntry = entries.lastOrNull()?.takeIf { it.metadata.containsKey(TAB_KEY) } ?: return null
        return NavigationSuiteBottomScene(
            key = tabEntry.contentKey,
            previousEntries = entries.dropLast(1),
            tabEntry = tabEntry,
            navigationItems = navigationItems
        )
    }

    companion object {
        private const val TAB_KEY = "NavigationSuiteSceneStrategy-Tab"
        fun tab() = mapOf(TAB_KEY to true)
    }
}

data class NavigationItem(
    val label: String?,
    val icon: ImageVector,
    val navKey: NavKey,
)
