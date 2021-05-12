package com.idm.moviedb.data.response.movie.toprated

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_toprated")
data class MovieTopRated(
    val backdrop_path: String,
    @PrimaryKey
    val id: Int,
    val poster_path: String,
    val title: String,
)