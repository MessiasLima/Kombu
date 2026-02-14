package dev.appoutlet.kombu.feature.signin

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.Navigation
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Factory

@Factory
class SignInNavigation : Navigation<NavKey> {
    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<SignInDestination> { SignInScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(SignInDestination::class, SignInDestination.serializer())
    }
}

@Serializable
data object SignInDestination : NavKey
