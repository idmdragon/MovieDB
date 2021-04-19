package com.idm.moviedb.data.source.remote

import com.idm.moviedb.data.source.remote.movie.MovieNowPlaying
import com.idm.moviedb.data.source.remote.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key")
        api_key: String
    ): Response<MovieNowPlaying>


    @GET("/3/search/multi")
    suspend fun multiSearch(
        @Query("api_key")
        api_key: String,
        @Query("query")
        query: String
    ): Response<SearchResponse>

}
