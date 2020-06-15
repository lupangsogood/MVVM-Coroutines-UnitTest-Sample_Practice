package com.lupin.myfirstmvvm.Application

import android.app.Application
import com.lupin.myfirstmvvm.BuildConfig
import com.lupin.myfirstmvvm.DI.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(applicationModule)
            }
        setUpTimber()
    }

    private fun setUpTimber(){
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}