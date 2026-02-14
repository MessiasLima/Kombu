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
import dev.appoutlet.kombu.LocalBackStack
import dev.appoutlet.kombu.feature.main.MainDestination
import kotlinx.serialization.Serializable

@Composable
fun SignInScreen() {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.safeDrawingPadding().padding(paddingValues)) {
            val backStack = LocalBackStack.current

            Text(text = "Sign In")

            Button(onClick = {
                backStack.add(MainDestination)
            }) {
                Text("Go to Main")
            }
        }
    }
}

@Serializable
data object SignInDestination : NavKey
