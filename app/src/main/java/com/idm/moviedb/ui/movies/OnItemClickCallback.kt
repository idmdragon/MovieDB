package com.idm.moviedb.ui.movies

import com.idm.moviedb.models.Movie


interface OnItemClickCallback {
    fun onItemClicked(movie : Movie )
}