package com.idm.moviedb.data.source.remote.response.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MovieResult(
    val backdrop_path: String,
    @PrimaryKey
    val id: Int,
    val vote_average: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
)