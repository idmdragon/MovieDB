package com.idm.moviedb.ui.favorite.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getAllFavoriteMovie() : LiveData<PagedList<MovieDetailResponse>> =
        LivePagedListBuilder(repository.getAllFavoriteMovie(), 10).build()


}