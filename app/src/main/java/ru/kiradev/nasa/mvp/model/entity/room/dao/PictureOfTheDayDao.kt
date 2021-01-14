package ru.kiradev.nasa.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.kiradev.nasa.mvp.model.entity.PictureOfTheDay
import ru.kiradev.nasa.mvp.model.entity.room.RoomPictureOfTheDay

@Dao
interface PictureOfTheDayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(picture: RoomPictureOfTheDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg pictures: RoomPictureOfTheDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pictures: List<RoomPictureOfTheDay>)

    @Update
    fun update(picture: RoomPictureOfTheDay)

    @Update
    fun update(vararg pictures: RoomPictureOfTheDay)

    @Update
    fun update(pictures: List<RoomPictureOfTheDay>)

    @Delete
    fun delete(picture: RoomPictureOfTheDay)

    @Delete
    fun delete(vararg pictures: RoomPictureOfTheDay)

    @Delete
    fun delete(pictures: List<RoomPictureOfTheDay>)

    @Query("SELECT * FROM RoomPictureOfTheDay")
    fun getAll(): List<RoomPictureOfTheDay>

    @Query("SELECT * FROM RoomPictureOfTheDay WHERE url = :url LIMIT 1")
    fun findByLogin(url: String): RoomPictureOfTheDay?

}