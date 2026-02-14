package dev.appoutlet.kombu.core.navigation

import org.koin.core.annotation.Factory

@Factory
class NavigationAggregator(val navigationList: List<Navigation<*>>)
