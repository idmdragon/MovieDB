package com.idm.moviedb.ui.search

import com.idm.moviedb.data.source.remote.search.SearchResult


interface OnItemClickCallback {
    fun onItemClicked(result: SearchResult)
}