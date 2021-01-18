package ru.kiradev.nasa.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kiradev.nasa.mvp.model.entity.PictureOfTheDay

interface IDataSource {

    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Single<PictureOfTheDay>

}
