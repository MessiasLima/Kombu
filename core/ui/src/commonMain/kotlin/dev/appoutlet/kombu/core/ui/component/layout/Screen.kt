package dev.appoutlet.kombu.core.ui.component.layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.appoutlet.kombu.core.mvi.Action
import dev.appoutlet.kombu.core.mvi.ContainerHost
import dev.appoutlet.kombu.core.mvi.MviState
import dev.appoutlet.kombu.core.mvi.ViewData
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Suppress("UNCHECKED_CAST")
@Composable
fun <ScreenViewData : ViewData, SiteEffect : Action, Event> Screen(
    viewModelProvider: @Composable () -> ContainerHost<SiteEffect, Event>,
    modifier: Modifier = Modifier,
    onTryAgain: (() -> Unit)? = null,
    error: @Composable (Throwable?) -> Unit = { DefaultErrorIndicator(it?.message, onTryAgain) },
    loading: @Composable (String?) -> Unit = { DefaultLoadingIndicator(it) },
    idle: @Composable () -> Unit = {},
    onAction: suspend (SiteEffect) -> Unit = {},
    content: @Composable (viewData: ScreenViewData, onEvent: (Event) -> Unit) -> Unit,
) {
    val viewModel = viewModelProvider()
    val state by viewModel.collectAsState()
    viewModel.collectSideEffect(sideEffect = onAction)

    AnimatedContent(modifier = modifier, targetState = state) { state ->
        when (state) {
            is MviState.Error -> error(state.throwable)

            is MviState.Loading -> loading(state.message)

            is MviState.Success<*> -> {
                val viewData = remember(state) {
                    state.data as? ScreenViewData ?: error("View data type mismatch")
                }
                content(viewData, viewModel::onEvent)
            }

            MviState.Idle -> idle()
        }
    }
}

@Composable
private fun DefaultErrorIndicator(
    errorMessage: String?,
    onTryAgain: (() -> Unit)?,
) {
    ErrorIndicator(
        modifier = Modifier.fillMaxSize(),
        stackTrace = errorMessage,
        onTryAgain = onTryAgain
    )
}

@Composable
private fun DefaultLoadingIndicator(
    message: String? = null
) {
    LoadingIndicator(modifier = Modifier.fillMaxSize(), message = message)
}
