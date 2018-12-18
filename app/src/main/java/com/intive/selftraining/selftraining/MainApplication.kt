package com.intive.selftraining.selftraining

import android.app.Application
import com.intive.selftraining.selftraining.di.DaggerAppComponent
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // startKoin(this, listOf(appModule))
        DaggerAppComponent.create().inject(this)
    }
}