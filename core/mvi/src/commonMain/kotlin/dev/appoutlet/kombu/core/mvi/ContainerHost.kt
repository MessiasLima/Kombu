package dev.appoutlet.kombu.core.mvi
import org.orbitmvi.orbit.ContainerHost as OrbitContainerHost

interface ContainerHost<T : Action, Event> : OrbitContainerHost<MviState, T> {
    fun onEvent(event: Event)
}
