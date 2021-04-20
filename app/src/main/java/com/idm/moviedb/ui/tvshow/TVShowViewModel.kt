package com.idm.moviedb.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.remote.RetrofitInstance
import com.idm.moviedb.data.source.remote.movie.MovieResult
import com.idm.moviedb.data.source.remote.tv.TvResult
import com.idm.moviedb.utils.Constant
import com.idm.moviedb.utils.Dummy
import kotlinx.coroutines.launch

class TVShowViewModel : ViewModel() {

    private val _listTvPopular = MutableLiveData<ArrayList<TvResult>>()
    val listTvPopular: LiveData<ArrayList<TvResult>> = _listTvPopular

    fun getTopRated() = viewModelScope.launch {
        RetrofitInstance.api.getTvPopular(Constant.API_KEY).let {
            _listTvPopular.postValue(it.body()?.results)
        }
    }

}