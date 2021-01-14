package ru.kiradev.nasa.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureOfTheDay(
    @Expose val copyright: String?,
    @Expose val date: String?,
    @Expose val explanation: String?,
    @Expose val mediaType: String?,
    @Expose val title: String?,
    @Expose val url: String?,
    @Expose val hdurl: String?
) : Parcelable