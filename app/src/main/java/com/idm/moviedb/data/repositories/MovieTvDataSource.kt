package com.idm.moviedb.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.remote.ApiResponse
import com.idm.moviedb.vo.Resource

interface MovieTvDataSource {

     //Remote
     fun getTopRated(): LiveData<Resource<PagedList<MovieTopRated>>>
     fun getNowPlaying(): LiveData<Resource<PagedList<MovieResult>>>
     fun getTvPopular(): LiveData<Resource<PagedList<TvResult>>>
     fun movieSearch(query: String) : LiveData<Resource<PagedList<SearchResult>>>
     fun getDetailMovie(movie_id: Int): LiveData<ApiResponse<MovieDetailResponse>>
     fun getDetailTv(tv_id: Int): LiveData<ApiResponse<TvDetailResponse>>

     //Local Database

     suspend fun insertMovie(movie : MovieDetailResponse)
     suspend fun insertTv(tv : TvDetailResponse)
     suspend fun deleteMovie(movie : MovieDetailResponse)
     suspend fun deleteTv(tv : TvDetailResponse)
     fun getAllFavoriteMovie(): DataSource.Factory<Int, MovieDetailResponse>
     fun getAllFavoriteTv(): DataSource.Factory<Int, TvDetailResponse>
     fun getMovieItem(id: Int): LiveData<MovieDetailResponse>
     fun getTvItem(id: Int): LiveData<TvDetailResponse>
}