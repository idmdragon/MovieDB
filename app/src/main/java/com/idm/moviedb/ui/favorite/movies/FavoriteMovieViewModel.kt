package com.idm.moviedb.ui.favorite.movies

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.source.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getAllFavoriteMovie() = repository.observeAllMovieItems()

}