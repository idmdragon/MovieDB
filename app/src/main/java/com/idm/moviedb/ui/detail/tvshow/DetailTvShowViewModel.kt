package com.idm.moviedb.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idm.moviedb.models.Movie
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.utils.Dummy

class DetailTvShowViewModel : ViewModel(){

    private val itemTvShow = MutableLiveData<TVShow>()
    val _itemTvShow : LiveData<TVShow> = itemTvShow

    fun setItem(title : String){
        val dummyData = Dummy.getTvShow()
        for(data in dummyData){
            if(data.title == title){
                itemTvShow.postValue(data)
            }
        }
    }

}