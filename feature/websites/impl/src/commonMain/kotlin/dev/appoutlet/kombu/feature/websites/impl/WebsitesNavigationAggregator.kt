package dev.appoutlet.kombu.feature.websites.impl

import org.koin.core.annotation.Single
import dev.appoutlet.kombu.core.navigation.WebsitesNavigation

@Single
class WebsitesNavigationAggregator(val navigation: List<WebsitesNavigation<*>>)
