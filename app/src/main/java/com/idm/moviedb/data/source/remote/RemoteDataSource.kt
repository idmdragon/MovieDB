package com.idm.moviedb.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.movie.MovieResponse
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.movie.toprated.MovieTopRatedResponse
import com.idm.moviedb.data.response.search.SearchResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResponse
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.utils.Constant
import com.idm.moviedb.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiService: ApiService) {


    fun getTopRated(): LiveData<ApiResponse<MovieTopRatedResponse>> {
        EspressoIdlingResource.increment()
        val listTopRated = MutableLiveData<ApiResponse<MovieTopRatedResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTopRated(Constant.API_KEY)
            if (response.isSuccessful) {
                listTopRated.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
            } else {
                listTopRated.postValue(response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return listTopRated
    }

    fun getNowPlaying(): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val listNowPlaying = MutableLiveData<ApiResponse<MovieResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getNowPlaying(Constant.API_KEY)
            if (response.isSuccessful) {
                listNowPlaying.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
            } else {
                listNowPlaying.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })

            }
        }
        return listNowPlaying
    }



    fun movieSearch(query: String): LiveData<ApiResponse<SearchResponse>>{
        val searchItemList = MutableLiveData<ApiResponse<SearchResponse>>()
        EspressoIdlingResource.increment()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.movieSearch(Constant.API_KEY, query)
            if (response.isSuccessful) {
                searchItemList.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
            } else {
                searchItemList.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return searchItemList
    }

    fun getTvPopular(): LiveData<ApiResponse<TvResponse>> {
        EspressoIdlingResource.increment()
        val listTvPopular = MutableLiveData<ApiResponse<TvResponse>>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTvPopular(Constant.API_KEY)
            if (response.isSuccessful) {
                listTvPopular.postValue(response.body()?.let { ApiResponse.success(it) })

            } else {
                listTvPopular.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return listTvPopular
    }

    fun getDetailMovie(movie_id: Int): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val detailMovie = MutableLiveData<ApiResponse<MovieDetailResponse>>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailMovie(movie_id, Constant.API_KEY)

            if (response.isSuccessful) {
                detailMovie.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
            } else {
                detailMovie.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return detailMovie
    }

    fun getDetailTv(tv_id: Int): LiveData<ApiResponse<TvDetailResponse>> {
        EspressoIdlingResource.increment()
        val detailTv = MutableLiveData<ApiResponse<TvDetailResponse>>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailTv(tv_id, Constant.API_KEY)
            if (response.isSuccessful) {
                detailTv.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
            } else {
                detailTv.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return detailTv
    }

}