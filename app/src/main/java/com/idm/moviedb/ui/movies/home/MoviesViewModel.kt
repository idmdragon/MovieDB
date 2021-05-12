package com.idm.moviedb.ui.movies.home

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {


    fun getTopRated() = repository.getTopRated()
    fun getNowPlaying() = repository.getNowPlaying()



}