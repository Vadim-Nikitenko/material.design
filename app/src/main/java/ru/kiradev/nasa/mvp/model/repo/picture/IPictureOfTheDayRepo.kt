package ru.kiradev.nasa.mvp.model.repo.picture

import io.reactivex.rxjava3.core.Single
import ru.kiradev.nasa.mvp.model.entity.PictureOfTheDay

interface IPictureOfTheDayRepo {
    fun getPictureOfTheDay(): Single<PictureOfTheDay>
}