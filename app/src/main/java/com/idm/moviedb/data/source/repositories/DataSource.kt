package com.idm.moviedb.data.source.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.models.movie.MovieResponse
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.models.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.models.search.SearchResponse
import com.idm.moviedb.data.models.search.SearchResult
import com.idm.moviedb.data.models.tv.TvResponse
import com.idm.moviedb.data.models.tv.TvResult
import com.idm.moviedb.data.models.tv.detail.TvDetailResponse
import retrofit2.Response

interface DataSource {
    suspend fun getTopRated(): LiveData<ArrayList<MovieResult>>

    suspend fun getNowPlaying(): LiveData<ArrayList<MovieResult>>

    suspend fun movieSearch(query: String)

    suspend fun getTvPopular(): LiveData<ArrayList<TvResult>>

    suspend fun getDetailMovie(movie_id: Int): LiveData<MovieDetailResponse>

    suspend fun getDetailTv(tv_id: Int): LiveData<TvDetailResponse>
}