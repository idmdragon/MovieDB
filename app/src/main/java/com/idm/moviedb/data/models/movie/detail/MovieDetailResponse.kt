package com.idm.moviedb.data.models.movie.detail

import com.idm.moviedb.data.models.movie.detail.Genre

data class MovieDetailResponse(
    val backdrop_path: String,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val vote_average: Double,
)