package dev.appoutlet.kombu.feature.links.impl

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.appoutlet.kombu.core.navigation.LocalNavigator

@Composable
fun LinksScreen() {
    val navigator = LocalNavigator.current
    Button(onClick = {
        navigator.goBack()
    }) {
        Text("Links")
    }
}
