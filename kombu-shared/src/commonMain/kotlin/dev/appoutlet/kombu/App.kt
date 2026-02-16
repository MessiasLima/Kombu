package dev.appoutlet.kombu

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import dev.appoutlet.kombu.core.navigation.LocalNavigator
import dev.appoutlet.kombu.core.navigation.Navigator
import dev.appoutlet.kombu.feature.signin.SignInDestination
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.koin.compose.koinInject


@Composable
fun App() {
    MaterialTheme {
        Navigation()
    }
}

@Composable
private fun Navigation() {
    val navigationAggregator = koinInject<AppNavigationAggregator>()

    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                for (navigation in navigationAggregator.navigationList) { navigation.setupPolymorphism(this) }
            }
        }
    }
    val backStack = rememberNavBackStack(configuration = config, SignInDestination)

    CompositionLocalProvider(LocalNavigator provides Navigator(backStack)) {
        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                for (navigation in navigationAggregator.navigationList) { navigation.setupRoute(this) }
            },
        )
    }
}
