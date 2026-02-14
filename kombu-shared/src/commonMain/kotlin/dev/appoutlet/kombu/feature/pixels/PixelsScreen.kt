package dev.appoutlet.kombu.feature.pixels

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Composable
fun PixelsScreen() {
    Text("Pixels")
}

@Serializable
data object PixelsDestination : NavKey
