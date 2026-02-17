package dev.appoutlet.kombu.feature.settings.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.UserCog
import dev.appoutlet.kombu.core.navigation.MainTabNavigation
import dev.appoutlet.kombu.feature.settings.SettingsDestination
import kombu.feature.settings.impl.generated.resources.Res
import kombu.feature.settings.impl.generated.resources.settings_tab
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class SettingsMainTabNavigation : MainTabNavigation<SettingsDestination> {
    override val key = SettingsDestination
    override val label = Res.string.settings_tab
    override val icon = Lucide.UserCog
    override val order = 3

    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<SettingsDestination> { SettingsScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(SettingsDestination::class, SettingsDestination.serializer())
    }
}
