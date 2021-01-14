package ru.kiradev.nasa.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomPictureOfTheDay(
    @PrimaryKey var url: String,
    var copyright: String,
    var date: String?,
    var mediaType: String,
    var title: String
)