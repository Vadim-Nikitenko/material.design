package ru.kiradev.nasa.di

import dagger.Component
import ru.kiradev.nasa.di.modules.*
import ru.kiradev.nasa.mvp.presenter.MainPresenter
import ru.kiradev.nasa.mvp.presenter.PictureOfTheDayPresenter
import ru.kiradev.nasa.ui.activity.MainActivity
import ru.kiradev.nasa.ui.fragment.PictureOfTheDayFragment
import ru.kiradev.nasa.ui.fragment.SettingsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        ApiModule::class,
        ImageModule::class,
        RepoModule::class
    ]
)

interface AppComponent {
    fun inject(mainPresenter: MainPresenter)
    fun inject(mainActivity: MainActivity)
    fun inject(pictureOfTheDayFragment: PictureOfTheDayFragment)
    fun inject(settingsFragment: SettingsFragment)
}