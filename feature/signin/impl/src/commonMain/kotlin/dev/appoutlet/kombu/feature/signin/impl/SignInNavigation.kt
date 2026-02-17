package dev.appoutlet.kombu.feature.signin.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.appoutlet.kombu.core.navigation.AppNavigation
import dev.appoutlet.kombu.feature.signin.SignInDestination
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import org.koin.core.annotation.Single

@Single
class SignInNavigation : AppNavigation<NavKey> {
    override fun setupRoute(scope: EntryProviderScope<NavKey>) {
        scope.entry<SignInDestination> { SignInScreen() }
    }

    override fun setupPolymorphism(builder: PolymorphicModuleBuilder<NavKey>) {
        builder.subclass(SignInDestination::class, SignInDestination.serializer())
    }
}
