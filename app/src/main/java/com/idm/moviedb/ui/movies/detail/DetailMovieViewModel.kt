package com.idm.moviedb.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.data.models.movie.detail.MovieDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    lateinit var detailMovie : LiveData<MovieDetailResponse>

    fun setDetail(id : Int) = viewModelScope.launch {
        detailMovie = repository.getDetailMovie(id)
    }


}