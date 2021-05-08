package com.idm.moviedb.ui.favorite.tvshow

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.source.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteTvViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getAllTvMovie() = repository.observeAllTvItems()

}