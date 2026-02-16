package dev.appoutlet.kombu

import dev.appoutlet.kombu.core.navigation.AppNavigation
import org.koin.core.annotation.Single

@Single
class AppNavigationAggregator(val navigationList: List<AppNavigation<*>>)
