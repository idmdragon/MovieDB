package com.idm.moviedb.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idm.moviedb.models.Movie
import com.idm.moviedb.utils.Dummy

class DetailMovieViewModel : ViewModel(){

    private val itemMovie = MutableLiveData<Movie>()
    val _itemMovie : LiveData<Movie> = itemMovie

    fun setItem(title : String){
        val dummyData = Dummy.getMovie()
        for(data in dummyData){
            if(data.title == title){
                itemMovie.postValue(data)
            }
        }
    }

}