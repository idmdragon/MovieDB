package com.idm.moviedb.ui.tvshow.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTvShowViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getDetailTV(id : Int) = repository.getDetailTv(id)

    suspend fun insertTv(tv : TvDetailResponse) =  repository.insertTv(tv)
    suspend fun deleteTv(tv : TvDetailResponse) =  repository.deleteTv(tv)

    fun getTvItem(id: Int) = repository.getTvItem(id)
    }

