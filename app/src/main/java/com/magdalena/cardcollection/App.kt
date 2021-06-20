package com.magdalena.cardcollection

import android.app.Application
import com.magdalena.cardcollection.inject.AppComponent
import com.magdalena.cardcollection.inject.ContextModule


class App : Application() {

    companion object {
        lateinit var injector: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))

            .build()
        injector.inject(this)

    }
}