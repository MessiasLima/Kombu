package dev.appoutlet.kombu.core.mvi

fun <SideEffect : Action> ContainerHost<SideEffect>.emitState(
    showLoading: Boolean = true,
    block: suspend () -> MviState
) {
    intent {
        try {
            if (showLoading) reduce { MviState.Loading() }
            val newState = block()
            reduce { newState }
        } catch (throwable: Throwable) {
            reduce { MviState.Error(throwable) }
        }
    }
}

fun <SideEffect : Action> ContainerHost<SideEffect>.emitState(mviState: MviState) {
    intent {
        reduce { mviState }
    }
}

fun <SideEffect : Action> ContainerHost<SideEffect>.emitAction(
    showLoading: Boolean = true,
    block: suspend () -> SideEffect
) {
    intent {
        try {
            if (showLoading) reduce { MviState.Loading() }
            postSideEffect(block())
        } catch (throwable: Throwable) {
            reduce { MviState.Error(throwable) }
        }
    }
}
