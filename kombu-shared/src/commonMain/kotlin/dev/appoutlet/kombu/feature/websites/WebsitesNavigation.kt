package dev.appoutlet.kombu.feature.websites

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.composables.icons.lucide.Globe
import com.composables.icons.lucide.Lucide
import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import kombu.kombu_shared.generated.resources.Res
import kombu.kombu_shared.generated.resources.main_tab_websites
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class WebsitesNavigation : MainTabNavigation<WebsitesDestination> {
    override val key = WebsitesDestination
    override val label = Res.string.main_tab_websites
    override val icon = Lucide.Globe

    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<WebsitesDestination> { WebsitesScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(WebsitesDestination::class, WebsitesDestination.serializer())
    }
}
