package com.idm.moviedb.ui.tvshow.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.models.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.data.models.tv.detail.TvDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTvShowViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    lateinit var detailTvShow : LiveData<TvDetailResponse>

    fun setDetail(id : Int) = viewModelScope.launch {
        detailTvShow = repository.getDetailTv(id)
    }

}