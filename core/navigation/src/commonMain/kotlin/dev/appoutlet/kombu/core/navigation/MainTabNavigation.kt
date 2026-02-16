package dev.appoutlet.kombu.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import org.jetbrains.compose.resources.StringResource

interface MainTabNavigation<T : NavKey> : Navigation<T> {
    val key: T
    val label: StringResource
    val icon: ImageVector
}
