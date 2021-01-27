package ru.kiradev.nasa.navigation

import ru.kiradev.nasa.ui.fragment.PictureOfTheDayFragment
import ru.kiradev.nasa.ui.fragment.PlanetsFragment
import ru.kiradev.nasa.ui.fragment.SettingsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class PictureScreen() : SupportAppScreen() {
        override fun getFragment() = PictureOfTheDayFragment.newInstance()
    }

    class SettingsScreen() : SupportAppScreen() {
        override fun getFragment() = SettingsFragment.newInstance()
    }

    class PlanetsScreen() : SupportAppScreen() {
        override fun getFragment() = PlanetsFragment.newInstance()
    }

}