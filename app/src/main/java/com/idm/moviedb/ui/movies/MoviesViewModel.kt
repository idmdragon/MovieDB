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

    private val _listTopRated = MutableLiveData<ArrayList<MovieResult>>()
    val listTopRated: LiveData<ArrayList<MovieResult>> = _listTopRated

    fun getTopRated() = viewModelScope.launch {
        RetrofitInstance.api.getTopRated(API_KEY).let {
            _listTopRated.postValue(it.body()?.results)
        }
    }

    private val _listPlayingNow = MutableLiveData<ArrayList<MovieResult>>()
    val listPlayingNow: LiveData<ArrayList<MovieResult>> = _listPlayingNow

    fun getNowPlaying() = viewModelScope.launch {
        RetrofitInstance.api.getNowPlaying(API_KEY).let {
            _listPlayingNow.postValue(it.body()?.results)
        }

    }



}