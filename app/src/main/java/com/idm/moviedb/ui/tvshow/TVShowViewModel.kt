package com.idm.moviedb.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.utils.Dummy

class TVShowViewModel : ViewModel() {

    fun getTVShow() = Dummy.getTvShow()

}