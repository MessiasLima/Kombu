package dev.appoutlet.kombu.feature.links

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.LocalNavigator
import kotlinx.serialization.Serializable

@Composable
fun LinksScreen() {
    val navigator = LocalNavigator.current
    Button(onClick = {
        navigator.goBack()
    }) {
        Text("Links")
    }
}

@Serializable
data object LinksDestination : NavKey
