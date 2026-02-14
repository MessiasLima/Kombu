package dev.appoutlet.kombu.feature.main

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontVariation
import androidx.navigation3.runtime.NavKey
import com.composables.icons.lucide.Globe
import com.composables.icons.lucide.Link
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Package
import com.composables.icons.lucide.Settings
import dev.appoutlet.kombu.LocalNavigator
import dev.appoutlet.kombu.feature.links.LinksDestination
import dev.appoutlet.kombu.feature.links.LinksScreen
import dev.appoutlet.kombu.feature.pixels.PixelsDestination
import dev.appoutlet.kombu.feature.pixels.PixelsScreen
import dev.appoutlet.kombu.feature.settings.SettingsDestination
import dev.appoutlet.kombu.feature.settings.SettingsScreen
import dev.appoutlet.kombu.feature.websites.WebsitesDestination
import dev.appoutlet.kombu.feature.websites.WebsitesScreen
import kombu.kombu_shared.generated.resources.Res
import kombu.kombu_shared.generated.resources.main_tab_links
import kombu.kombu_shared.generated.resources.main_tab_pixels
import kombu.kombu_shared.generated.resources.main_tab_settings
import kombu.kombu_shared.generated.resources.main_tab_websites
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen() {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            tabs.forEachIndexed { index, item ->
                item(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(stringResource(item.label)) }
                )
            }
        },
        content = {
            AnimatedContent(targetState = selectedTab) {
                when(it) {
                    0 -> WebsitesScreen()
                    1 -> LinksScreen()
                    2 -> PixelsScreen()
                    3 -> SettingsScreen()
                }
            }
        }
    )
}

private val tabs = listOf(
    NavigationItem(
        label = Res.string.main_tab_websites,
        icon = Lucide.Globe,
    ),

    NavigationItem(
        label = Res.string.main_tab_links,
        icon = Lucide.Link,
    ),

    NavigationItem(
        label = Res.string.main_tab_pixels,
        icon = Lucide.Package,
    ),

    NavigationItem(
        label = Res.string.main_tab_settings,
        icon = Lucide.Settings,
    ),
)

data class NavigationItem(
    val label: StringResource,
    val icon: ImageVector,
)
