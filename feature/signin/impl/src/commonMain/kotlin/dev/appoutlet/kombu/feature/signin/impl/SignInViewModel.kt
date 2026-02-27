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

// We cant use Hilt because it is JVM only, and we want to share this code with iOS, so we use Koin instead
@KoinViewModel
class SignInViewModel(
    private val umamiAuthRepository: UmamiAuthRepository,
) : ViewModel(), ContainerHost<SignInAction> {

    // The ContainerHost interface and this container property are part of the MVI architecture library: Orbit.
    // The container holds the state and actions for the view model.
    override val container = container<SignInAction> {
        // This is the initial loading block. It is called when the start observing the state on the container.
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
