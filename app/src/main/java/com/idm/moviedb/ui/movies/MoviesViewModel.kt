package com.idm.moviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.MainRepository
import com.idm.moviedb.data.source.remote.movie.MovieResult
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _listTopRated = MutableLiveData<ArrayList<MovieResult>>()
    val listTopRated: LiveData<ArrayList<MovieResult>> = _listTopRated

    fun getTopRated() = viewModelScope.launch {
        repository.getTopRated().let {
            _listTopRated.postValue(it.body()?.results)
        }
    }

    private val _listPlayingNow = MutableLiveData<ArrayList<MovieResult>>()
    val listPlayingNow: LiveData<ArrayList<MovieResult>> = _listPlayingNow

    fun getNowPlaying() = viewModelScope.launch {
        repository.getNowPlaying().let {
            _listPlayingNow.postValue(it.body()?.results)
        }

    }



}