package com.idm.moviedb.data.source.repositories

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse

interface DataSource {

     //Remote

     fun getTopRated(): LiveData<ArrayList<MovieResult>>

     fun getNowPlaying(): LiveData<ArrayList<MovieResult>>

     fun movieSearch(query: String) : LiveData<ArrayList<SearchResult>>

     fun getTvPopular(): LiveData<ArrayList<TvResult>>

     fun getDetailMovie(movie_id: Int): LiveData<MovieDetailResponse>

     fun getDetailTv(tv_id: Int): LiveData<TvDetailResponse>

     //Local Database

     suspend fun insertMovie(movie : MovieDetailResponse)

     suspend fun insertTv(tv : TvDetailResponse)

     suspend fun deleteMovie(movie : MovieDetailResponse)

     suspend fun deleteTv(tv : TvDetailResponse)

     fun observeAllMovieItems(): LiveData<List<MovieDetailResponse>>

     fun observeAllTvItems(): LiveData<List<TvDetailResponse>>

     fun getMovieItem(id: Int): LiveData<MovieDetailResponse>

     fun getTvItem(id: Int): LiveData<TvDetailResponse>
}