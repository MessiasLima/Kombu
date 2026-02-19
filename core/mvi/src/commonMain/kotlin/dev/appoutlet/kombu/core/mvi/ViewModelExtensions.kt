package dev.appoutlet.kombu.core.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.SettingsBuilder
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.Syntax

fun <SIDE_EFFECT : Any> ViewModel.container(
    buildSettings: SettingsBuilder.() -> Unit = {},
    onCreate: (suspend Syntax<MviState, SIDE_EFFECT>.() -> Unit)? = null
): Container<MviState, SIDE_EFFECT> {
    return viewModelScope.container(MviState.Idle, buildSettings, onCreate)
}
