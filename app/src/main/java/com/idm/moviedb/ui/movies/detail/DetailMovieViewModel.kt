package com.idm.moviedb.ui.movies.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.source.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getDetailMovie(id : Int) = repository.getDetailMovie(id)

    suspend fun insertMovie(movie : MovieDetailResponse) =  repository.insertMovie(movie)
    suspend fun deleteMovie(movie: MovieDetailResponse) = repository.deleteMovie(movie)

    fun getMovieItem(id: Int) = repository.getMovieItem(id)
    }


