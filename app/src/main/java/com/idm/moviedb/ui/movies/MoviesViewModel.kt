package com.idm.moviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idm.moviedb.models.Movie
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.utils.Dummy

class MoviesViewModel : ViewModel() {
    private val listMovie = MutableLiveData<ArrayList<Movie>>()
    val _listMovie : LiveData<ArrayList<Movie>> = listMovie

    fun setMovie(){
        listMovie.postValue(Dummy.getMovie())
    }

}