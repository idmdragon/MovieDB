package com.idm.moviedb.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.utils.Dummy

class TVShowViewModel : ViewModel() {
    private val listTVShow = MutableLiveData<ArrayList<TVShow>>()
    val _listTVShow : LiveData<ArrayList<TVShow>> = listTVShow

    fun setMovie(){
        listTVShow.postValue(Dummy.getTvShow())
    }

}