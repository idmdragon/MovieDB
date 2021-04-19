package com.idm.moviedb.data.source.remote.search

data class SearchResult(
    val backdrop_path: String,
    val id: Int,
    val media_type: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
)