package dev.appoutlet.kombu.feature.signin.impl

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.appoutlet.kombu.core.ui.component.layout.Screen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignInScreen() = Screen<SignInViewData, SignInAction>(
    viewModelProvider = { koinViewModel<SignInViewModel>() },
    onAction = ::onAction
) {
    Scaffold {
        Text("Sign In Screen")
    }
}

private suspend fun onAction(action: SignInAction) {
    when (action) {
        SignInAction.NavigateToHome -> {
            // Handle navigation to home screen
        }
    }
}
