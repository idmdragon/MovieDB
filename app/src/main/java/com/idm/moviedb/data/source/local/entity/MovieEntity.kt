package com.idm.moviedb.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.idm.moviedb.data.source.remote.response.movie.detail.Genres
import java.lang.reflect.Type

@TypeConverters(genreConverters::class)
@Entity(tableName = "movie_list")
data class MovieEntity(
    val backdrop_path: String ="",
    val budget: Int= 0,
    val genres: List<Genres>,
    @PrimaryKey
    val id: Int,
    val original_language: String="",
    val original_title: String="",
    val overview: String="",
    val poster_path: String="",
    val release_date: String="",
    val revenue: Int= 0,
    val status: String="",
    val tagline: String="",
    val title: String="",
    val vote_average: Double = 0.0,
    var favorite : Boolean = false
)

class genreConverters{
    @TypeConverter
    fun stringToMeasurements(json: String?): List<Genres> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Genres?>?>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun measurementsToString(list: List<Genres?>?): String {
        val gson = Gson()
        val type: Type = object : TypeToken<List<Genres?>?>() {}.type
        return gson.toJson(list, type)
    }
}