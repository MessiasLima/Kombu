package dev.appoutlet

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kombu.kombu_shared.generated.resources.Res
import kombu.kombu_shared.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun App() {
    MaterialTheme {
        Text(stringResource(Res.string.app_name))
    }
}
