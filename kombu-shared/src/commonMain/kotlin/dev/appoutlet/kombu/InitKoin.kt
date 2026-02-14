package dev.appoutlet.kombu

import co.touchlab.kermit.koin.KermitKoinLogger
import dev.appoutlet.kombu.core.logging.getLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


/**
 * Initializes the Koin dependency injection framework for the application.
 *
 * This method:
 * - Starts the Koin application context.
 * - Sets up a logger using the Kermit logging library with the tag "Koin".
 * - Applies the provided `koinApplication` lambda for custom configurations.
 * - Registers the dependency injection modules from `AppModule`.
 *
 * @param koinApplication A lambda with a receiver of type `KoinApplication` that allows
 * additional configuration of the Koin application. Defaults to an empty implementation.
 */
fun initKoin() {
    startKoin {
        logger(KermitKoinLogger(getLogger("Koin")))
        modules(AppModule().module)
    }
}
