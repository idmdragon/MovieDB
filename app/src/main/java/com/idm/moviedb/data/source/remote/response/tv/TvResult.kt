package com.idm.moviedb.data.source.remote.response.tv

import androidx.room.PrimaryKey

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