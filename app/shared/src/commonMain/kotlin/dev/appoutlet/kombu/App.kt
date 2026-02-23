package dev.appoutlet.kombu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import dev.appoutlet.kombu.core.navigation.LocalNavigator
import dev.appoutlet.kombu.core.navigation.Navigator
import dev.appoutlet.kombu.core.navigation.getSavedStateConfiguration
import dev.appoutlet.kombu.core.ui.theme.KombuTheme
import dev.appoutlet.kombu.feature.signin.SignInDestination
import org.koin.compose.koinInject

@Composable
fun App() {
    KombuTheme {
        Navigation()
    }
}

@Composable
private fun Navigation() {
    val navigationAggregator = koinInject<AppNavigationAggregator>()

    val config = remember(navigationAggregator) { getSavedStateConfiguration(navigationAggregator.navigation) }
    val backStack = rememberNavBackStack(configuration = config, SignInDestination)

    CompositionLocalProvider(LocalNavigator provides Navigator(backStack)) {
        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                for (navigation in navigationAggregator.navigation) { navigation.setupRoute(this) }
            },
        )
    }
}
