package com.idm.moviedb.data.source.remote.response.movie.detail



data class MovieDetailResponse(
    val backdrop_path: String ="",
    val budget: Int= 0,
    val genres: List<Genres>,
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
)


