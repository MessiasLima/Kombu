package dev.appoutlet.kombu.feature.main

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Composable
fun MainScreen() {
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            item(selected = true, icon = {}, label = {
                Text("Websites")
            }, onClick = {

            })
            item(selected = true, icon = {}, label = {
                Text("Links")
            }, onClick = {})
            item(selected = true, icon = {}, label = {
                Text("Pixels")
            }, onClick = {})
            item(selected = true, icon = {}, label = {
                Text("Settings")
            }, onClick = {})
        }
    ) {
        Scaffold { paddingValues ->

        }
    }
}

@Serializable
data object MainDestination : NavKey
