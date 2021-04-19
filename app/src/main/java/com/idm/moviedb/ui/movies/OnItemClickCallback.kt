package com.idm.moviedb.ui.movies

import com.idm.moviedb.data.source.remote.movie.MovieResult


interface OnItemClickCallback {
    fun onItemClicked(movie : MovieResult)
}