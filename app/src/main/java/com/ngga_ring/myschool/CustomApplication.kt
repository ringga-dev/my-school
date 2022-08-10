package com.ngga_ring.myschool

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.ngga_ring.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CustomApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }

        Kotpref.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}