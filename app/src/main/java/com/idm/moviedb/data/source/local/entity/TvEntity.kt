package com.idm.moviedb.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.idm.moviedb.data.source.remote.response.tv.detail.Genre
import java.lang.reflect.Type

@TypeConverters(genreConverter::class)
@Entity(tableName = "tv_list")
data class TvEntity(
    val backdrop_path: String = "",
    val genres: List<Genre>,
    @PrimaryKey
    val id: Int,
    val name: String = "",
    val number_of_episodes: Int= 0,
    val overview: String = "",
    val poster_path: String = "",
    val status: String = "",
    val tagline: String= "",
    val vote_average: Double= 0.0,
    val first_air_date: String,
    var favorite : Boolean = false
)

class genreConverter {
    @TypeConverter
    fun stringToMeasurements(json: String?): List<Genre> {
        val gson = Gson()
        val type: Type =
            object : TypeToken<List<Genre?>?>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun measurementsToString(list: List<Genre?>?): String {
        val gson = Gson()
        val type: Type =
            object : TypeToken<List<Genre?>?>() {}.type
        return gson.toJson(list, type)
    }
}