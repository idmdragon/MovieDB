package com.idm.moviedb.data.source.remote

import com.idm.moviedb.data.response.movie.MovieResponse
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.search.SearchResponse
import com.idm.moviedb.data.response.tv.TvResponse
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("/3/movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id")
        movie_id: Int,
        @Query("api_key")
        api_key: String,
    ): Response<MovieDetailResponse>

    @GET("/3/tv/{tv_id}")
    suspend fun getDetailTv(
        @Path("tv_id")
        tv_id: Int,
        @Query("api_key")
        api_key: String,
    ): Response<TvDetailResponse>
}
