package dev.appoutlet.kombu.core.navigation.levels

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.Navigation
import org.jetbrains.compose.resources.StringResource

interface MainTabNavigation<T : NavKey> : Navigation<T> {
    val key: T
    val label: StringResource
    val icon: ImageVector
    val order: Int
}
