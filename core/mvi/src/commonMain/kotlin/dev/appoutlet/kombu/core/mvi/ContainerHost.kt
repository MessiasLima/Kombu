package dev.appoutlet.kombu.core.mvi
import org.orbitmvi.orbit.ContainerHost as OrbitContainerHost

interface ContainerHost<T : Any> : OrbitContainerHost<MviState, T>
