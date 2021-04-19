package com.idm.moviedb.ui.detail.movie

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.source.remote.movie.MovieDetail
import com.idm.moviedb.utils.Dummy

class DetailMovieViewModel : ViewModel(){

    private lateinit var itemMovie : MovieDetail


    fun setItem(title : String){
        val dummyData = Dummy.getMovie()
        for(data in dummyData){
            if(data.title == title){
                itemMovie = data
            }
        }
    }

    fun getItem(): MovieDetail {
        return itemMovie
    }

}