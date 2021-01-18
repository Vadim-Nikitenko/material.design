package ru.kiradev.nasa.ui

import android.app.Application
import ru.kiradev.nasa.di.AppComponent
import ru.kiradev.nasa.di.DaggerAppComponent
import ru.kiradev.nasa.di.modules.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    }

}