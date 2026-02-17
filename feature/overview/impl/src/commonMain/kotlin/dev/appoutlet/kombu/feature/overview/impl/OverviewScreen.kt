package dev.appoutlet.kombu.feature.overview.impl

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.dropUnlessResumed
import dev.appoutlet.kombu.core.navigation.LocalNavigator

@Composable
fun OverviewScreen() {
    val navigator = LocalNavigator.current
    Button(onClick = dropUnlessResumed { navigator.goBack() }) {
        Text("Overview")
    }
}
