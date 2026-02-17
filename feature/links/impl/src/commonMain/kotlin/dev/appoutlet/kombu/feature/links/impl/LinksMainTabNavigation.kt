package dev.appoutlet.kombu.feature.links.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.composables.icons.lucide.Link
import com.composables.icons.lucide.Lucide
import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import dev.appoutlet.kombu.feature.links.LinksDestination
import kombu.feature.links.impl.generated.resources.Res
import kombu.feature.links.impl.generated.resources.main_tab_links
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class LinksMainTabNavigation : MainTabNavigation<LinksDestination> {
    override val key = LinksDestination
    override val label = Res.string.main_tab_links
    override val icon = Lucide.Link
    override val order = 1

    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<LinksDestination> { LinksScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(LinksDestination::class, LinksDestination.serializer())
    }
}
