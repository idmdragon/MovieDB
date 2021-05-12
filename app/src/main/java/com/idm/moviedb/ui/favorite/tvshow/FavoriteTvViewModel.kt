package com.idm.moviedb.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteTvViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getAllTvMovie() : LiveData<PagedList<TvDetailResponse>> =
        LivePagedListBuilder(repository.getAllFavoriteTv(), 10).build()



}