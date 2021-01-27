package ru.kiradev.nasa.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView: MvpView {
    fun setBottomNavigation()
    fun onNavMainClicked()
    fun onNavPlanetsClicked()
    fun onNavSettingsClicked()
}