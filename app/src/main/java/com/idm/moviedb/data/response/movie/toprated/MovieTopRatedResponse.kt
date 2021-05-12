package com.idm.moviedb.data.response.movie.toprated


data class MovieTopRatedResponse(
    val results: ArrayList<MovieTopRated>,
    val page: Int? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)