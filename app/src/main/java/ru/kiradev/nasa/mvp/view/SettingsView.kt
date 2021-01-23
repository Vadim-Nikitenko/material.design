package ru.kiradev.nasa.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface SettingsView : MvpView {
    fun switchToDarkTheme()
    fun switchToDefaultTheme()
}