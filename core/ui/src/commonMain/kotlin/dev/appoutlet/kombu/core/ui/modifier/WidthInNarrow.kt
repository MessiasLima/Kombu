package dev.appoutlet.kombu.core.ui.modifier

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_MEDIUM_LOWER_BOUND

@Composable
fun Modifier.widthInNarrow() : Modifier {
    return this.then(Modifier.widthIn(max = WIDTH_DP_MEDIUM_LOWER_BOUND.dp))
}
