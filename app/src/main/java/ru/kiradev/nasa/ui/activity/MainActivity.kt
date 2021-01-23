package ru.kiradev.nasa.ui.activity

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.kiradev.nasa.R
import ru.kiradev.nasa.databinding.ActivityMainBinding
import ru.kiradev.nasa.mvp.presenter.MainPresenter
import ru.kiradev.nasa.mvp.view.MainView
import ru.kiradev.nasa.navigation.Screens
import ru.kiradev.nasa.ui.App
import ru.kiradev.nasa.ui.BackButtonListener
import ru.kiradev.nasa.ui.fragment.PictureOfTheDayFragment
import ru.kiradev.nasa.ui.fragment.SettingsFragment.Companion.SP_KEY_THEME
import ru.kiradev.nasa.ui.fragment.SettingsFragment.Companion.SP_KEY_THEME_STATE
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private lateinit var binding: ActivityMainBinding

    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    @Inject
    lateinit var sharedPrefs: SharedPreferences

    val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        App.instance.appComponent.inject(this)
        setupTheme()
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setupTheme() {
        when(sharedPrefs.getInt(SP_KEY_THEME, 1)) {
            1 -> setTheme(R.style.Theme_Nasa)
            2 -> setTheme(R.style.Theme_Nasa_Dark)
        }
        if (sharedPrefs.getBoolean(SP_KEY_THEME_STATE, false)) {
            router.replaceScreen(Screens.SettingsScreen())
            sharedPrefs.edit().apply { putBoolean(SP_KEY_THEME_STATE, false) }.apply()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                binding.bottomNavigation.selectedItemId = R.id.bn_main
                return
            }
        }
        presenter.backClick()
    }

    override fun setBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bn_main -> presenter.navMainClicked()
                R.id.bn_planets -> presenter.navPlanetsClicked()
                R.id.bn_settings -> presenter.navSettingsClicked()
                else -> false
            }
        }
    }

    override fun onNavMainClicked() {
        router.replaceScreen(Screens.PictureScreen())
    }

    override fun onNavPlanetsClicked() {
        router.replaceScreen(Screens.PlanetsScreen())
    }

    override fun onNavSettingsClicked() {
        router.replaceScreen(Screens.SettingsScreen())
    }


}
