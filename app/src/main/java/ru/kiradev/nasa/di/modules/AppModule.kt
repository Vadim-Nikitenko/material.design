package ru.kiradev.nasa.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.kiradev.nasa.mvp.model.repo.picture.IPictureOfTheDayRepo
import ru.kiradev.nasa.mvp.presenter.PictureOfTheDayPresenter
import ru.kiradev.nasa.mvp.view.PictureView
import ru.kiradev.nasa.ui.App
import ru.terrakok.cicerone.Router
import javax.inject.Provider

@Module
class AppModule(val app: App) {

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    fun app(): App {
        return app
    }

    @Provides
    fun sharedPreferences(): SharedPreferences = app.getSharedPreferences("SP", Context.MODE_PRIVATE)

}