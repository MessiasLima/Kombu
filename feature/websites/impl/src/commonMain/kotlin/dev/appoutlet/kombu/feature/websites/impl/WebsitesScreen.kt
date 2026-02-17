package dev.appoutlet.kombu.feature.websites.impl

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import dev.appoutlet.kombu.core.navigation.LocalNavigator
import dev.appoutlet.kombu.feature.overview.OverviewDestination

@Composable
fun WebsitesScreen() {
    val navigator = LocalNavigator.current

    SideEffect {
        println("WebsitesScreen SideEffect")
    }

    Button(onClick = {
        navigator.goBack()
    }) {
        Text("Websites")
    }

    Button(onClick = {
        navigator.navigate(OverviewDestination)
    }) {
        Text("Overview")
    }
}
