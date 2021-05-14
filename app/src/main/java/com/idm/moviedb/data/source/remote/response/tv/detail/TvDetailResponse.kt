package com.idm.moviedb.data.source.remote.response.tv.detail


data class TvDetailResponse(
    val backdrop_path: String = "",
    val genres: List<Genre>,
    val id: Int,
    val name: String = "",
    val number_of_episodes: Int= 0,
    val overview: String = "",
    val poster_path: String = "",
    val status: String = "",
    val tagline: String= "",
    val vote_average: Double= 0.0,
    val first_air_date: String,
    )


