package dev.appoutlet.kombu.core.ui.theme

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun KombuTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content, motionScheme = MotionScheme.expressive())
}
