package dev.appoutlet.kombu.feature.websites

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Composable
fun WebsitesScreen() {
    Text("Websites")
}

@Serializable
data object WebsitesDestination : NavKey
