package dev.appoutlet.kombu.feature.websites.impl

import dev.appoutlet.kombu.core.navigation.WebsitesNavigation
import org.koin.core.annotation.Single

@Single
class WebsitesNavigationAggregator(val navigation: List<WebsitesNavigation<*>>)
