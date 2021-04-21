package com.idm.moviedb.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.MainRepository
import com.idm.moviedb.data.source.remote.movie.detail.MovieDetailResponse
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _detailMovie = MutableLiveData<MovieDetailResponse>()
    val detailMovie: LiveData<MovieDetailResponse> = _detailMovie


    fun setDetail(id : Int) = viewModelScope.launch {
        repository.getDetailMovie(id).let {
            _detailMovie.postValue(it.body())
        }
    }


}