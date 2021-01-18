package ru.kiradev.nasa.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface PictureView: MvpView {
    fun setPicture(url: String?)
    fun setVideo(url: String?)
    fun setPictureTitle(title: String?)
    fun setPictureExplanation(explanation: String?)
    fun searchWiki()
    fun showBottomSheet()
    fun hideBottomSheer()
    fun showVideoView()
    fun hideVideoView()
}