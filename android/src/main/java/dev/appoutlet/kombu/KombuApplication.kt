package dev.appoutlet.kombu

import android.app.Application
import org.koin.android.ext.koin.androidContext

class KombuApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@KombuApplication)
        }
    }
}
