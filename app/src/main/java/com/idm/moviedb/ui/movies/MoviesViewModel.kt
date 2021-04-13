package com.idm.moviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idm.moviedb.models.Movie
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.utils.Dummy

class MoviesViewModel : ViewModel() {

    fun getMovie()= Dummy.getMovie()

}