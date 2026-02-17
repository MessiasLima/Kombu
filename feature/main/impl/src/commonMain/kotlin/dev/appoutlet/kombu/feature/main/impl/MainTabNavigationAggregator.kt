package dev.appoutlet.kombu.feature.main.impl

import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import org.koin.core.annotation.Single

@Single
class MainTabNavigationAggregator(private val navigationList: List<MainTabNavigation<*>>) {
    val navigation = navigationList.sortedBy { it.order }
}
