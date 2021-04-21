package com.idm.moviedb.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.MainRepository
import com.idm.moviedb.data.source.remote.tv.detail.TvDetailResponse
import com.idm.moviedb.utils.Constant
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailTvShowViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _detailTv = MutableLiveData<TvDetailResponse>()
    val detailMovie: LiveData<TvDetailResponse> = _detailTv


    fun setDetail(id : Int) = viewModelScope.launch {
        repository.getDetailTv(id).let {
            _detailTv.postValue(it.body())
        }
    }

}