package com.idm.moviedb.data.response.search

data class SearchResult(
    val backdrop_path: String,
    val id: Int,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
)