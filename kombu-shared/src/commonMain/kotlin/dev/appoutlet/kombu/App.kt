package dev.appoutlet.kombu

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import dev.appoutlet.kombu.feature.links.LinksDestination
import dev.appoutlet.kombu.feature.links.LinksScreen
import dev.appoutlet.kombu.feature.main.MainDestination
import dev.appoutlet.kombu.feature.main.MainScreen
import dev.appoutlet.kombu.feature.main.NavigationSuiteSceneStrategy
import dev.appoutlet.kombu.feature.main.rememberNavigationSuiteSceneStrategy
import dev.appoutlet.kombu.feature.overview.OverviewDestination
import dev.appoutlet.kombu.feature.overview.OverviewScreen
import dev.appoutlet.kombu.feature.pixels.PixelsDestination
import dev.appoutlet.kombu.feature.pixels.PixelsScreen
import dev.appoutlet.kombu.feature.settings.SettingsDestination
import dev.appoutlet.kombu.feature.settings.SettingsScreen
import dev.appoutlet.kombu.feature.signin.SignInDestination
import dev.appoutlet.kombu.feature.signin.SignInScreen
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import dev.appoutlet.kombu.feature.websites.WebsitesScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(SignInDestination::class, SignInDestination.serializer())
            subclass(MainDestination::class, MainDestination.serializer())
            subclass(WebsitesDestination::class, WebsitesDestination.serializer())
            subclass(LinksDestination::class, LinksDestination.serializer())
            subclass(PixelsDestination::class, PixelsDestination.serializer())
            subclass(SettingsDestination::class, SettingsDestination.serializer())
            subclass(OverviewDestination::class, OverviewDestination.serializer())
        }
    }
}

@Composable
fun App() {
    MaterialTheme {
        val backStack = rememberNavBackStack(configuration = config, SignInDestination)
        val navigationSuiteSceneStrategy = rememberNavigationSuiteSceneStrategy<NavKey>()

        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
            ),
            sceneStrategy = navigationSuiteSceneStrategy,
            entryProvider = entryProvider {
                entry<SignInDestination> { SignInScreen() }
                entry<MainDestination>(
                    metadata = NavigationSuiteSceneStrategy.main()
                ) { MainScreen() }
                entry<WebsitesDestination>(
                    metadata = NavigationSuiteSceneStrategy.tab()
                ) { WebsitesScreen() }
                entry<LinksDestination> { LinksScreen() }
                entry<PixelsDestination> { PixelsScreen() }
                entry<SettingsDestination> { SettingsScreen() }
                entry<OverviewDestination> { OverviewScreen() }
            },
        )
    }
}

val LocalBackStack = compositionLocalOf<NavBackStack<NavKey>> { error("No NavBackStack provided") }
