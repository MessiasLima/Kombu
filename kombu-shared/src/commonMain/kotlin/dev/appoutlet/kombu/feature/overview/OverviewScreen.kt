package dev.appoutlet.kombu.feature.overview

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Composable
fun OverviewScreen() {
    Text("Overview")
}

@Serializable
data object OverviewDestination : NavKey
