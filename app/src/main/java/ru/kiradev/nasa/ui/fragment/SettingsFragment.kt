package ru.kiradev.nasa.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.kiradev.nasa.databinding.FragmentSettingsBinding
import ru.kiradev.nasa.mvp.presenter.SettingsPresenter
import ru.kiradev.nasa.mvp.view.SettingsView
import ru.kiradev.nasa.ui.App
import ru.kiradev.nasa.ui.BackButtonListener
import javax.inject.Inject
import javax.inject.Provider

class SettingsFragment : MvpAppCompatFragment(), SettingsView, BackButtonListener {

    companion object {
        fun newInstance() = SettingsFragment()
        const val SP_KEY_THEME = "ThemeKey"
        const val SP_KEY_THEME_STATE = "ThemeChanged"
    }

    @Inject
    lateinit var presenterProvider: Provider<SettingsPresenter>

    private var binding: FragmentSettingsBinding? = null

    private val presenter by moxyPresenter { presenterProvider.get() }

    @Inject
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setThemeSwitch()
        setOnThemeSwitchChangeBehaviour()
    }

    private fun setOnThemeSwitchChangeBehaviour() {
        binding?.switchDarkTheme?.setOnCheckedChangeListener { buttonView, isChecked ->
            when (isChecked) {
                true -> presenter.darkThemeEnabled()
                false -> presenter.darkThemeDisabled()
            }
        }
    }

    private fun setThemeSwitch() {
        when (sharedPrefs.getInt(SP_KEY_THEME, 1)) {
            1 -> binding?.switchDarkTheme?.isChecked = false
            2 -> binding?.switchDarkTheme?.isChecked = true
        }
    }

    override fun backPressed(): Boolean {
        presenter?.backClick()
        return true
    }

    override fun switchToDarkTheme() {
        sharedPrefs.edit().apply { putInt(SP_KEY_THEME, 2) }.apply()
        sharedPrefs.edit().apply { putBoolean(SP_KEY_THEME_STATE, true) }.apply()
        activity?.recreate()
    }

    override fun switchToDefaultTheme() {
        sharedPrefs.edit().apply { putInt(SP_KEY_THEME, 1) }.apply()
        sharedPrefs.edit().apply { putBoolean(SP_KEY_THEME_STATE, true) }.apply()
        activity?.recreate()
    }

}