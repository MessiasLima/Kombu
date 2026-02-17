package dev.appoutlet.kombu.feature.pixels.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.composables.icons.lucide.LayoutGrid
import com.composables.icons.lucide.Lucide
import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import dev.appoutlet.kombu.feature.pixels.PixelsDestination
import kombu.feature.pixels.impl.generated.resources.Res
import kombu.feature.pixels.impl.generated.resources.pixels_tab
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class PixelsMainTabNavigation : MainTabNavigation<PixelsDestination> {
    override val key = PixelsDestination
    override val label = Res.string.pixels_tab
    override val icon = Lucide.LayoutGrid
    override val order = 2

    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<PixelsDestination> { PixelsScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(PixelsDestination::class, PixelsDestination.serializer())
    }
}
