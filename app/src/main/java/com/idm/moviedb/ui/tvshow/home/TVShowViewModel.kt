package com.idm.moviedb.ui.tvshow.home

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TVShowViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    fun getTvPopular() = repository.getTvPopular()

}