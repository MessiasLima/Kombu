package dev.appoutlet.kombu.feature.main.impl

import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import org.koin.core.annotation.Single

@Single
class MainTabNavigationAggregator(val navigationList: List<MainTabNavigation<*>>)
