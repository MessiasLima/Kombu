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

// This will be used in the Android, iOS and Desktop apps
@Composable
fun App() {
    KombuTheme {
        Navigation()
    }
}

@Composable
private fun Navigation() {
    // The list of destinations
    val navigationAggregator = koinInject<AppNavigationAggregator>()

    // Polymorphism config. KMP does not support reflection
    val config = remember(navigationAggregator) { getSavedStateConfiguration(navigationAggregator.navigation) }

    // The navigation back stack
    val backStack = rememberNavBackStack(configuration = config, SignInDestination)

    // Providing navigator (like the NavController) to be used by the screens
    CompositionLocalProvider(LocalNavigator provides Navigator(backStack)) {
        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                // setup all routes from the aggregator
                for (navigation in navigationAggregator.navigation) { navigation.setupRoute(this) }
            },
        )
    }
}
