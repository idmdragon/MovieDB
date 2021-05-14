package com.idm.moviedb.data.source.remote.response.movie


data class MovieResponse(
    val results: ArrayList<MovieResult>,
    val page: Int? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)