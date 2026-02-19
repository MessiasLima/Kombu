package dev.appoutlet.kombu.core.ui.component.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.appoutlet.kombu.core.mvi.MviState
import dev.appoutlet.kombu.core.ui.modifier.widthInNarrow

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoadingIndicator(modifier: Modifier = Modifier, message: String? = null) {
    Box(modifier, contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth().widthInNarrow().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContainedLoadingIndicator(
                modifier = Modifier.size(64.dp)
            )

            message?.let {
                Spacer(Modifier.size(16.dp))
                Text(text = it, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
