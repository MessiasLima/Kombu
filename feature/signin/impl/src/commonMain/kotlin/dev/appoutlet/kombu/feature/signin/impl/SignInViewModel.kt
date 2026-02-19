package dev.appoutlet.kombu.feature.signin.impl

import androidx.lifecycle.ViewModel
import dev.appoutlet.kombu.core.mvi.Action
import dev.appoutlet.kombu.core.mvi.ContainerHost
import dev.appoutlet.kombu.core.mvi.MviState
import dev.appoutlet.kombu.core.mvi.ViewData
import dev.appoutlet.kombu.core.mvi.container
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SignInViewModel : ViewModel(), ContainerHost<SignInAction> {
    override val container = container<SignInAction>()

    init {
        intent { reduce { MviState.Success(SignInViewData("", ""))} }
    }
}


data class SignInViewData(
    val username: String,
    val password: String
) : ViewData

sealed interface SignInAction : Action {
    object NavigateToHome : SignInAction
}
