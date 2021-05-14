package com.idm.moviedb.data.source.remote.response.tv

data class TvResponse(
    val results: ArrayList<TvResult>,
    val page: Int? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)