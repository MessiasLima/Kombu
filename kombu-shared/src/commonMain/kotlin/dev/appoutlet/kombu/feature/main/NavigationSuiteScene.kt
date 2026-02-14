package dev.appoutlet.kombu.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.scene.SceneStrategyScope
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND

class NavigationSuiteBottomScene<T : Any>(
    override val key: Any,
    override val previousEntries: List<NavEntry<T>>,
    private val mainEntry: NavEntry<T>,
    private val tabEntry: NavEntry<T>,
) : Scene<T> {
    override val entries: List<NavEntry<T>> = listOf(mainEntry, tabEntry)

    override val content: @Composable (() -> Unit) = {
        Column {
            tabEntry.Content()
            mainEntry.Content()
        }
    }
}

class NavigationSuiteRailScene<T : Any>(
    override val key: Any,
    override val previousEntries: List<NavEntry<T>>,
    private val mainEntry: NavEntry<T>,
    private val tabEntry: NavEntry<T>,
) : Scene<T> {
    override val entries: List<NavEntry<T>> = listOf(mainEntry, tabEntry)

    override val content: @Composable (() -> Unit) = {
        Row {
            mainEntry.Content()
            tabEntry.Content()
        }
    }
}

@Composable
fun <T : Any> rememberNavigationSuiteSceneStrategy(): NavigationSuiteSceneStrategy<T> {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    return remember(windowSizeClass) {
        NavigationSuiteSceneStrategy(windowSizeClass)
    }
}

class NavigationSuiteSceneStrategy<T : Any>(
    private val windowSizeClass: WindowSizeClass,
) : SceneStrategy<T> {
    override fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T>? {
        val mainEntry = entries.findLast { it.metadata.containsKey(MAIN_KEY) } ?: return null
        val tabEntry = entries.findLast { it.metadata.containsKey(TAB_KEY) } ?: return null
        val sceneKey = mainEntry.contentKey
        val isScreenAtLeastMedium = windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_MEDIUM_LOWER_BOUND)
        return if (isScreenAtLeastMedium) {
            NavigationSuiteRailScene(
                key = sceneKey,
                previousEntries = entries,
                mainEntry = mainEntry,
                tabEntry = tabEntry,
            )
        } else {
            NavigationSuiteBottomScene(
                key = sceneKey,
                previousEntries = entries,
                mainEntry = mainEntry,
                tabEntry = tabEntry,
            )
        }
    }

    companion object {
        private const val MAIN_KEY = "NavigationSuiteSceneStrategy-Main"
        private const val TAB_KEY = "NavigationSuiteSceneStrategy-Tab"
        fun main() = mapOf(MAIN_KEY to true)
        fun tab() = mapOf(TAB_KEY to true)
    }
}

