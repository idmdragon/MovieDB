package com.idm.moviedb.data.response.search

data class SearchResponse(
    val results: ArrayList<SearchResult>,
    val total_results: Int
)