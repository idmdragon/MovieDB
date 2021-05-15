package com.idm.moviedb.ui.tvshow.detail

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.TvEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailTvShowViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getDetailTV(id : Int) = repository.getDetailTv(id)
    fun updateTv(tv: TvEntity) = repository.updateTv(tv)

    }

