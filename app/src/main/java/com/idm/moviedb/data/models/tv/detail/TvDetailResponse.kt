package com.idm.moviedb.data.models.tv.detail

import com.idm.moviedb.data.models.tv.detail.Genre

data class TvDetailResponse(
    val backdrop_path: String,
    val genres: List<Genre>,
    val id: Int,
    val name: String,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val status: String,
    val tagline: String,
    val vote_average: Double,
)