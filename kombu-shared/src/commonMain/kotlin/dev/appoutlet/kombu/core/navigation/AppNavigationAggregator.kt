package dev.appoutlet.kombu.core.navigation

import org.koin.core.annotation.Single

@Single
class AppNavigationAggregator(val navigationList: List<AppNavigation<*>>)
