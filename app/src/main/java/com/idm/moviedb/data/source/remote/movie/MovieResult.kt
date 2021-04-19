package com.idm.moviedb.data.source.remote.movie

data class MovieResult(
    val backdrop_path: String,
    val id: Int,
    val vote_average: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
)