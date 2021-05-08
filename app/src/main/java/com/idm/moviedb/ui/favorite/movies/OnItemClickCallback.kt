package com.idm.moviedb.ui.favorite.movies

import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse


interface OnItemClickCallback {
    fun onItemClicked(movies: MovieDetailResponse)
}