package ru.kiradev.nasa.ui.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.kiradev.nasa.databinding.FragmentPictureOfTheDayBinding
import ru.kiradev.nasa.mvp.model.image.IImageLoader
import ru.kiradev.nasa.mvp.presenter.PictureOfTheDayPresenter
import ru.kiradev.nasa.mvp.view.PictureView
import ru.kiradev.nasa.ui.App
import ru.kiradev.nasa.ui.BackButtonListener
import javax.inject.Inject

class PictureOfTheDayFragment : MvpAppCompatFragment(), PictureView, BackButtonListener {
    private var binding: FragmentPictureOfTheDayBinding? = null
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    companion object {
        fun newInstance() = PictureOfTheDayFragment()
    }

    val presenter by moxyPresenter {
        PictureOfTheDayPresenter().apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        App.instance.appComponent.inject(this)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.wikiIconClicked()
        binding?.bottomSheetLayout?.bottomSheet?.let { setBottomSheetBehavior(it) }
        binding?.ivPictureOfTheDay?.setOnClickListener {
            presenter.pictureOfTheDayClicked()
        }
    }

    private fun setBottomSheetBehavior(bottomSheet: LinearLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
    }

    override fun backPressed(): Boolean {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) presenter.backClickBottomSheetOpened()
        else presenter.backClick()
        return true
    }


    override fun setPicture(url: String?) {
        binding?.ivPictureOfTheDay?.let { imageLoader.loadInto(url, it) }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun setVideo(url: String?) {
        binding?.wvPictureOfTheDay?.clearCache(true);
        binding?.wvPictureOfTheDay?.clearHistory();
        binding?.wvPictureOfTheDay?.settings?.javaScriptEnabled = true
        binding?.wvPictureOfTheDay?.settings?.javaScriptCanOpenWindowsAutomatically = true
        url?.let { binding?.wvPictureOfTheDay?.loadUrl(url) }
    }

    override fun setPictureTitle(title: String?) {
        binding?.tvPictureTitle?.text = title
    }

    override fun setPictureExplanation(explanation: String?) {
        binding?.bottomSheetLayout?.tvBottomSheetDescription?.text = explanation
    }

    override fun searchWiki() {
        binding?.tilWiki?.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding?.etWiki?.text.toString()}")
            })
        }
    }

    override fun showBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun hideBottomSheer() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun showVideoView() {
        binding?.wvPictureOfTheDay?.visibility = View.VISIBLE
    }

    override fun hideVideoView() {
        binding?.wvPictureOfTheDay?.visibility = View.GONE
    }

}