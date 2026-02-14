package dev.appoutlet.kombu.core.logging

import co.touchlab.kermit.Logger
import co.touchlab.kermit.mutableLoggerConfigInit
import co.touchlab.kermit.platformLogWriter

fun getLogger(tag: String): Logger {
    val loggerConfig = mutableLoggerConfigInit(
        logWriters = arrayOf(
            platformLogWriter(),
        ),
    )

    return Logger(loggerConfig).withTag(tag)
}
