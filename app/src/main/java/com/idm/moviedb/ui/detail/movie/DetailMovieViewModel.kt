package com.idm.moviedb.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.remote.RetrofitInstance
import com.idm.moviedb.data.source.remote.movie.detail.MovieDetailResponse
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.launch

class DetailMovieViewModel : ViewModel(){

    private val _detailMovie = MutableLiveData<MovieDetailResponse>()
    val detailMovie: LiveData<MovieDetailResponse> = _detailMovie


    fun setDetail(id : Int) = viewModelScope.launch {
        RetrofitInstance.api.getDetailMovie(id,API_KEY).let {
            _detailMovie.postValue(it.body())
        }
    }


}