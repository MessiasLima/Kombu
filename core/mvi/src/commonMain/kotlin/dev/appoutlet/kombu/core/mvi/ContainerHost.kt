package dev.appoutlet.kombu.core.mvi
import org.orbitmvi.orbit.ContainerHost as OrbitContainerHost

interface ContainerHost<SideEffect : Action, Event> : OrbitContainerHost<MviState, SideEffect> {
    fun onEvent(event: Event)
}
