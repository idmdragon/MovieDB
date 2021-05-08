package com.idm.moviedb.ui.movies.home

import com.idm.moviedb.data.response.movie.MovieResult


interface OnItemClickCallback {
    fun onItemClicked(movie : MovieResult)
}