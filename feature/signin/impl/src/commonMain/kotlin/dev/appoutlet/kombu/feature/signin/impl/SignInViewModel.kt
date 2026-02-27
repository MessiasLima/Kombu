package dev.appoutlet.kombu.feature.signin.impl

import androidx.lifecycle.ViewModel
import dev.appoutlet.kombu.core.mvi.Action
import dev.appoutlet.kombu.core.mvi.ContainerHost
import dev.appoutlet.kombu.core.mvi.State
import dev.appoutlet.kombu.core.mvi.ViewData
import dev.appoutlet.kombu.core.mvi.container
import dev.appoutlet.kombu.core.mvi.emitAction
import dev.appoutlet.kombu.core.mvi.emitState
import dev.appoutlet.kombu.data.umami.auth.UmamiAuthRepository
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SignInViewModel(
    private val umamiAuthRepository: UmamiAuthRepository,
) : ViewModel(), ContainerHost<SignInAction> {

    override val container = container<SignInAction> {
        emitState(State.Success(SignInViewData))
    }

    fun onTryAgain() {
        emitState(State.Success(SignInViewData))
    }

    fun onEvent(event: SignInEvent) {
        when (event) {
            is SignInEvent.OnSubmit -> emitAction {
                umamiAuthRepository.login(event.username, event.password)
                SignInAction.NavigateToHome
            }
        }
    }
}

data object SignInViewData : ViewData

sealed interface SignInAction : Action {
    object NavigateToHome : SignInAction
}

sealed interface SignInEvent {
    data class OnSubmit(val username: String, val password: String) : SignInEvent
}
