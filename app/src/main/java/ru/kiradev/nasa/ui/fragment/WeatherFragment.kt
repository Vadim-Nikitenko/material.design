package ru.kiradev.nasa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import ru.kiradev.nasa.R

class WeatherFragment : MvpAppCompatFragment() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
}