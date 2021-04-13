package com.idm.moviedb.ui.tvshow

import com.idm.moviedb.models.TVShow


interface OnItemClickCallback {
    fun onItemClicked(tvShow: TVShow )
}