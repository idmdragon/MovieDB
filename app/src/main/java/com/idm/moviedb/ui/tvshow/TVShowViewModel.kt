package com.idm.moviedb.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.MainRepository
import com.idm.moviedb.data.source.remote.tv.TvResult
import com.idm.moviedb.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVShowViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    private val _listTvPopular = MutableLiveData<ArrayList<TvResult>>()
    val listTvPopular: LiveData<ArrayList<TvResult>> = _listTvPopular

    fun getTopRated() = viewModelScope.launch {
        repository.getTvPopular().let {
            _listTvPopular.postValue(it.body()?.results)
        }
    }

}