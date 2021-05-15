package com.idm.moviedb.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.TvEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteTvViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getAllTvMovie() : LiveData<PagedList<TvEntity>> = repository.getAllFavoriteTv()



}