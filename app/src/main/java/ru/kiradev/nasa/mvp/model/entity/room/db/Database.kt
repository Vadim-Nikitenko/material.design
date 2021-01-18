package ru.kiradev.nasa.mvp.model.entity.room.db

import androidx.room.RoomDatabase
import ru.kiradev.nasa.mvp.model.entity.room.RoomPictureOfTheDay
import ru.kiradev.nasa.mvp.model.entity.room.dao.PictureOfTheDayDao

@androidx.room.Database(entities = [RoomPictureOfTheDay::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val pictureOfTheDay: PictureOfTheDayDao

    companion object {
        const val DB_NAME = "database.db"
        private var instance: Database? = null
    }

}