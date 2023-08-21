package com.test.unleashdemo

import android.app.Application
import com.test.unleashdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UnleashApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@UnleashApplication)
            modules(appModule)
        }
    }

}