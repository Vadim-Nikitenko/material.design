package ru.kiradev.nasa.mvp.presenter

import moxy.MvpPresenter
import ru.kiradev.nasa.mvp.view.PlanetsView
import ru.kiradev.nasa.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class PlanetsPresenter @Inject constructor(private val router: Router) :
    MvpPresenter<PlanetsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backClick() {
        router.replaceScreen(Screens.PictureScreen())
    }

}