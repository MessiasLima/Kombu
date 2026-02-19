package dev.appoutlet.kombu.feature.signin.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.appoutlet.kombu.core.logging.logger
import dev.appoutlet.kombu.core.mvi.Action
import dev.appoutlet.kombu.core.mvi.ContainerHost
import dev.appoutlet.kombu.core.mvi.MviState
import dev.appoutlet.kombu.core.mvi.ViewData
import dev.appoutlet.kombu.core.mvi.container
import dev.appoutlet.kombu.data.umami.auth.UmamiAuthRepository
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SignInViewModel(private val umamiAuthRepository: UmamiAuthRepository) : ViewModel(),
    ContainerHost<SignInAction, SignInEvent> {
    val log by logger()

    override val container = container<SignInAction> {
        reduce { MviState.Success(SignInViewData) }
    }

    override fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnSubmit -> onSubmit(event.username, event.password)
        }
    }

    private fun onSubmit(username: String, password: String) = viewModelScope.launch {
        intent {
            reduce { MviState.Loading() }
            val user = umamiAuthRepository.login(username, password)
            reduce { MviState.Success(SignInViewData) }
        }
    }
}

object SignInViewData : ViewData

sealed interface SignInAction : Action {
    object NavigateToHome : SignInAction
}

sealed interface SignInEvent {
    data class OnSubmit(val username: String, val password: String) : SignInEvent
}
