package dev.appoutlet.kombu.feature.signin.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.appoutlet.kombu.core.mvi.ContainerHost
import dev.appoutlet.kombu.core.mvi.MviState
import dev.appoutlet.kombu.core.mvi.container
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SignInViewModel : ViewModel(), ContainerHost<SignInAction> {
    override val container = container<SignInAction>()

    init {
        intent { reduce { MviState.Error(Throwable("Sample error")) } }
    }
}


data class SignInViewData(
    val username: String,
    val password: String
)

sealed interface SignInAction {
    object NavigateToHome : SignInAction
}
