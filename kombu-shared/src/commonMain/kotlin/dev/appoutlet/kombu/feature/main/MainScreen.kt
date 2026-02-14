package dev.appoutlet.kombu.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.LocalNavigator
import dev.appoutlet.kombu.feature.links.LinksDestination
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import kotlinx.serialization.Serializable

@Composable
fun MainScreen() {
    val navigator = LocalNavigator.current

    Column(modifier = Modifier.background(color = Color.Red)) {
        SideEffect {
            println("MainScreen SideEffect")
        }

        Button(onClick = { navigator.navigate(WebsitesDestination) }) {
            Text("Websites")
        }

        Button(onClick = { navigator.navigate(LinksDestination) }) {
            Text("Links")
        }
    }
}

@Serializable
data object MainDestination : NavKey
