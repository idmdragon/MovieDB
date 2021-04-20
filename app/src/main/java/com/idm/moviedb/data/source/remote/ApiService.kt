package com.idm.moviedb.data.source.remote

import com.idm.moviedb.data.source.remote.movie.MovieResponse
import com.idm.moviedb.data.source.remote.search.SearchResponse
import com.idm.moviedb.data.source.remote.tv.TvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/3/movie/top_rated")
    suspend fun getTopRated(
        @Query("api_key")
        api_key: String
    ): Response<MovieResponse>

    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key")
        api_key: String
    ): Response<MovieResponse>

    @GET("/3/search/movie")
    suspend fun movieSearch(
        @Query("api_key")
        api_key: String,
        @Query("query")
        query: String
    ): Response<SearchResponse>

    @GET("/3/tv/popular")
    suspend fun getTvPopular(
        @Query("api_key")
        api_key: String,

    ): Response<TvResponse>
}
