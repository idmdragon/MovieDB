package com.idm.moviedb.ui.tvshow.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.data.models.tv.TvResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVShowViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    lateinit var listTvPopular: LiveData<ArrayList<TvResult>>

    fun getTvPopular() = viewModelScope.launch {
        listTvPopular = repository.getTvPopular()
    }

    suspend fun getTvValueTvPopular() = repository.getTvPopular()

}