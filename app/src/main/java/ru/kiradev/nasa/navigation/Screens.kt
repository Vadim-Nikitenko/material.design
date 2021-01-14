package ru.kiradev.nasa.navigation

import ru.kiradev.nasa.ui.fragment.PictureOfTheDayFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {



    class PictureScreen() : SupportAppScreen() {
        override fun getFragment() = PictureOfTheDayFragment.newInstance()
    }

}