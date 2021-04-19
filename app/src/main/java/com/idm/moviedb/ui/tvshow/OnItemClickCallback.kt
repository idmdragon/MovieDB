package com.idm.moviedb.ui.tvshow

import com.idm.moviedb.data.source.remote.TVShow


interface OnItemClickCallback {
    fun onItemClicked(tvShow: TVShow)
}