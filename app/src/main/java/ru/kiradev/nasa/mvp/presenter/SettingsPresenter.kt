package ru.kiradev.nasa.mvp.presenter

import moxy.MvpPresenter
import ru.kiradev.nasa.mvp.view.SettingsView
import ru.kiradev.nasa.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SettingsPresenter @Inject constructor(private val router: Router,): MvpPresenter<SettingsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backClick() {
        router.backTo(Screens.PictureScreen())
    }

    fun darkThemeEnabled() {
        viewState.switchToDarkTheme()
    }

    fun darkThemeDisabled() {
        viewState.switchToDefaultTheme()
    }


}