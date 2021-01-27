package ru.kiradev.nasa.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ru.kiradev.nasa.R
import ru.kiradev.nasa.ui.fragment.EarthFragment
import ru.kiradev.nasa.ui.fragment.MarsFragment
import ru.kiradev.nasa.ui.fragment.WeatherFragment

private const val EARTH_FRAGMENT = 0
private const val MARS_FRAGMENT = 1
private const val WEATHER_FRAGMENT = 2

class ViewPagerAdapter(private val fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = arrayOf(EarthFragment(), MarsFragment(), WeatherFragment())

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> EarthFragment.newInstance()
            1 -> MarsFragment.newInstance()
            2 -> WeatherFragment.newInstance()
            else -> EarthFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Earth"
            1 -> "Mars"
            2 -> "Weather"
            else -> "Earth"
        }
    }
}