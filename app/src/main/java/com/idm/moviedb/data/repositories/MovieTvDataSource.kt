package com.idm.moviedb.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.vo.Resource

interface MovieTvDataSource {

    fun getMovieList(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getTvPopular(): LiveData<Resource<PagedList<TvEntity>>>
    fun getDetailMovie(movie_id: Int): LiveData<Resource<MovieEntity>>
    fun getDetailTv(tv_id: Int): LiveData<Resource<TvEntity>>
    fun updateMovie(movie: MovieEntity)
    fun updateTv(tv: TvEntity)
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun getAllFavoriteTv(): LiveData<PagedList<TvEntity>>
}