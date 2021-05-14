package com.idm.moviedb.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.data.source.remote.response.movie.MovieResult
import com.idm.moviedb.data.source.remote.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.source.remote.response.tv.TvResult
import com.idm.moviedb.data.source.remote.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.remote.ApiResponse
import com.idm.moviedb.vo.Resource

interface MovieTvDataSource {

     fun getNowPlaying(): LiveData<Resource<PagedList<MovieEntity>>>
     fun getTvPopular(): LiveData<Resource<PagedList<TvEntity>>>
     fun getDetailMovie(movie_id: Int): LiveData<Resource<MovieEntity>>
     fun getDetailTv(tv_id: Int): LiveData<Resource<TvEntity>>
     suspend fun updateMovie(movie : MovieEntity)
     suspend fun updateTv(tv : TvEntity)
     fun getAllFavoriteMovie(): LiveData<PagedList<MovieEntity>>
     fun getAllFavoriteTv(): LiveData<PagedList<TvEntity>>
}