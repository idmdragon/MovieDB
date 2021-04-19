package com.idm.moviedb.data.source.remote.search

data class SearchResponse(
    val results: ArrayList<SearchResult>,
    val total_results: Int
)