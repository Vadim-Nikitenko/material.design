package ru.kiradev.nasa.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String?, container: T)
}