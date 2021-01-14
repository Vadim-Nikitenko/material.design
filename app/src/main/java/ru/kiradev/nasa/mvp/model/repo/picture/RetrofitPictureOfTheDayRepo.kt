package ru.kiradev.nasa.mvp.model.repo.picture

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.kiradev.nasa.BuildConfig
import ru.kiradev.nasa.mvp.model.api.IDataSource
import ru.kiradev.nasa.mvp.model.entity.PictureOfTheDay

class RetrofitPictureOfTheDayRepo(
    private val api: IDataSource
) : IPictureOfTheDayRepo {

    override fun getPictureOfTheDay(): Single<PictureOfTheDay> =
        api.getPictureOfTheDay(BuildConfig.NASA_API_KEY).subscribeOn(Schedulers.io())

}