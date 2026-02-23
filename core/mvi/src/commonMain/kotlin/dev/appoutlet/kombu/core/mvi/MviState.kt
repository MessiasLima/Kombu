package dev.appoutlet.kombu.core.mvi

sealed interface MviState {
    object Idle : MviState
    data class Loading(val message: String? = null) : MviState
    data class Success<T : ViewData>(val data: T) : MviState
    data class Error(val throwable: Throwable? = null) : MviState
}
