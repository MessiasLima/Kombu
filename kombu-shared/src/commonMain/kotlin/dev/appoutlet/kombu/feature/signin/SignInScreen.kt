package dev.appoutlet.kombu.feature.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.LocalNavigator
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import kotlinx.serialization.Serializable

@Composable
fun SignInScreen() {
    Scaffold { paddingValues ->
        val navigator = LocalNavigator.current
        Column(modifier = Modifier.safeDrawingPadding().padding(paddingValues)) {

            Text(text = "Sign In")

            Button(onClick = {
                navigator.navigate(WebsitesDestination)
            }) {
                Text("Go to Main")
            }
        }
    }
}

@Serializable
data object SignInDestination : NavKey
