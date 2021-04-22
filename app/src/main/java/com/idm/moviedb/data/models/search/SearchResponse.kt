package com.idm.moviedb.data.models.search

data class SearchResponse(
    val results: ArrayList<SearchResult>,
    val total_results: Int
)