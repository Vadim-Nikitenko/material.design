package ru.kiradev.nasa.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import moxy.MvpPresenter
import ru.kiradev.nasa.mvp.model.repo.picture.IPictureOfTheDayRepo
import ru.kiradev.nasa.mvp.view.PictureView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class PictureOfTheDayPresenter @Inject constructor(
    private val router: Router,
    private val pictureRepo: IPictureOfTheDayRepo,
    private val scheduler: Scheduler
) : MvpPresenter<PictureView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        pictureRepo.getPictureOfTheDay()
            .observeOn(scheduler)
            .subscribe({
                if (it.mediaType == "video") {
                    viewState.showVideoView()
                    viewState.setVideo(it.url)
                } else {
                    viewState.hideVideoView()
                    it.url.let { viewState.setPicture(it) }
                }
                viewState.setPictureTitle(it.title)
                viewState.setPictureExplanation(it.explanation)
            }, {
                it.printStackTrace()
            }).addTo(compositeDisposable)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    fun wikiIconClicked() {
        viewState.searchWiki()
    }

    fun pictureOfTheDayClicked() {
        viewState.showBottomSheet()
    }

    fun backClickBottomSheetOpened() {
        viewState.hideBottomSheet()
    }

    fun bottomSheetExpanded() {
        viewState.showBottomSheet()
    }

    fun bottomSheetCollapsed() {
        viewState.hideBottomSheet()
    }
}