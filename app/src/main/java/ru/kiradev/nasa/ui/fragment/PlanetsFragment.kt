package ru.kiradev.nasa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.kiradev.nasa.databinding.FragmentPlanetsBinding
import ru.kiradev.nasa.mvp.presenter.PlanetsPresenter
import ru.kiradev.nasa.mvp.view.PlanetsView
import ru.kiradev.nasa.ui.App
import ru.kiradev.nasa.ui.BackButtonListener
import ru.kiradev.nasa.ui.adapter.ViewPagerAdapter
import javax.inject.Inject
import javax.inject.Provider

class PlanetsFragment : MvpAppCompatFragment(), PlanetsView, BackButtonListener {

    companion object {
        fun newInstance() = PlanetsFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<PlanetsPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }
    private var binding: FragmentPlanetsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,b
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanetsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewPager?.adapter = ViewPagerAdapter(childFragmentManager)
    }

    override fun onDestroyView() {
        binding = null
        binding?.viewPager?.adapter = null
        super.onDestroyView()
    }

    override fun backPressed(): Boolean {
        presenter?.backClick()
        return true
    }

}