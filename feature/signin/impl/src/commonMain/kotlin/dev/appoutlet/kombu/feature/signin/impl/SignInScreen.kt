package dev.appoutlet.kombu.feature.signin.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.appoutlet.kombu.core.navigation.LocalNavigator
import dev.appoutlet.kombu.feature.main.MainDestination

@Composable
fun SignInScreen() {
    Scaffold { paddingValues ->
        val navigator = LocalNavigator.current
        Column(modifier = Modifier.safeDrawingPadding().padding(paddingValues)) {

            Text(text = "Sign In")

            Button(onClick = {
                navigator.navigate(MainDestination)
            }) {
                Text("Go to Main")
            }
        }
    }
}
