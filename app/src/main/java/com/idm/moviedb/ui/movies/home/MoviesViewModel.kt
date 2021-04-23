package com.idm.moviedb.ui.movies.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.data.models.movie.MovieResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    lateinit var listTopRated: LiveData<ArrayList<MovieResult>>
    lateinit var listPlayingNow: LiveData<ArrayList<MovieResult>>

    fun getTopRated() = viewModelScope.launch {
        listTopRated = repository.getTopRated()
    }

    fun getNowPlaying() = viewModelScope.launch {
        listPlayingNow = repository.getNowPlaying()
    }

    suspend fun getTopValue() = repository.getTopRated()
    suspend fun getNowPlayingValue() = repository.getNowPlaying()

}