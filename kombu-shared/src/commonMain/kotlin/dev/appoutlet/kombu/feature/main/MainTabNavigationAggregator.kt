package dev.appoutlet.kombu.feature.main

import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import org.koin.core.annotation.Single

@Single
class MainTabNavigationAggregator(val navigationList: List<MainTabNavigation<*>>)
