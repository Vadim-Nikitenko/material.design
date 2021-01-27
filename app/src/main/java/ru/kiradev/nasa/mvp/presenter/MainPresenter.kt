package ru.kiradev.nasa.mvp.presenter

import moxy.MvpPresenter
import ru.kiradev.nasa.mvp.view.MainView
import ru.kiradev.nasa.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.PictureScreen())
    }

    fun backClick() = router.exit()

    fun navMainClicked() = viewState.onNavMainClicked().run { true }

    fun navPlanetsClicked() = viewState.onNavPlanetsClicked().run { true }

    fun navSettingsClicked() = viewState.onNavSettingsClicked().run { true }

}