package com.idm.moviedb.ui.home

import com.idm.moviedb.models.Movie


interface OnItemClickCallback {
    fun onItemClicked(movie : Movie )
}