package com.idm.moviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.remote.RetrofitInstance
import com.idm.moviedb.data.source.remote.movie.MovieResult
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    private val _listMoviePlayingNow = MutableLiveData<ArrayList<MovieResult>>()
    val listMoviePlayingNow: LiveData<ArrayList<MovieResult>> = _listMoviePlayingNow
    fun getMovie() = viewModelScope.launch {
        RetrofitInstance.api.getNowPlaying(API_KEY).let {
            _listMoviePlayingNow.postValue(it.body()?.results)
        }

    }
}