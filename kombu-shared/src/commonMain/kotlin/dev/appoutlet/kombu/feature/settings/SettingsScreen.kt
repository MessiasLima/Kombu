package dev.appoutlet.kombu.feature.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Composable
fun SettingsScreen() {
    Text("Settings")
}

@Serializable
data object SettingsDestination : NavKey
