package com.idm.moviedb.ui.search

import com.idm.moviedb.data.models.search.SearchResult


interface OnItemClickCallback {
    fun onItemClicked(result: SearchResult)
}