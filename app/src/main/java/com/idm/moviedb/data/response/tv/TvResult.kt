package com.idm.moviedb.data.response.tv

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_list")
data class TvResult(
    val backdrop_path: String,
    val first_air_date: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Double,
)