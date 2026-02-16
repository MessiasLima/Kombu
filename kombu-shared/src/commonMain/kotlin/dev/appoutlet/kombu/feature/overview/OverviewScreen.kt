package dev.appoutlet.kombu.feature.overview

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.dropUnlessResumed
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.LocalNavigator
import kotlinx.serialization.Serializable

@Composable
fun OverviewScreen() {
    val navigator = LocalNavigator.current
    Button(onClick = dropUnlessResumed { navigator.goBack() }) {
        Text("Overview")
    }
}

@Serializable
data object OverviewDestination : NavKey
