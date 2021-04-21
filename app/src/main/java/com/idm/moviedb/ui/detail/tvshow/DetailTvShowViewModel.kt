package com.idm.moviedb.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.remote.RetrofitInstance
import com.idm.moviedb.data.source.remote.tv.detail.TvDetailResponse
import com.idm.moviedb.utils.Constant
import kotlinx.coroutines.launch

class DetailTvShowViewModel : ViewModel(){

    private val _detailTv = MutableLiveData<TvDetailResponse>()
    val detailMovie: LiveData<TvDetailResponse> = _detailTv


    fun setDetail(id : Int) = viewModelScope.launch {
        RetrofitInstance.api.getDetailTv(id, Constant.API_KEY).let {
            _detailTv.postValue(it.body())
        }
    }

}