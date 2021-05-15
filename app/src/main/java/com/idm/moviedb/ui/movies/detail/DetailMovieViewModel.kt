package com.idm.moviedb.ui.movies.detail

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.MovieEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getDetailMovie(id : Int) = repository.getDetailMovie(id)
    fun updateMovie(movie: MovieEntity) = repository.updateMovie(movie)

    }


