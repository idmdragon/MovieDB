package com.idm.moviedb.data.source

import com.idm.moviedb.data.source.remote.ApiService
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTopRated() = apiService.getTopRated(API_KEY)

    suspend fun getNowPlaying() = apiService.getNowPlaying(API_KEY)

    suspend fun movieSearch(query : String) = apiService.movieSearch(API_KEY,query)

    suspend fun getTvPopular() = apiService.getTvPopular(API_KEY)

    suspend fun getDetailMovie(movieId : Int) = apiService.getDetailMovie(movieId,API_KEY)

    suspend fun getDetailTv(tvId : Int) = apiService.getDetailTv(tvId,API_KEY)
}