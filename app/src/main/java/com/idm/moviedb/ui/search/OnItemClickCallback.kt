package com.idm.moviedb.ui.search

import com.idm.moviedb.data.response.search.SearchResult


interface OnItemClickCallback {
    fun onItemClicked(result: SearchResult)
}