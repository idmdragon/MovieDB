package com.idm.moviedb.data.response.movie


data class MovieResponse(
    val results: ArrayList<MovieResult>,
    val page: Int? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)