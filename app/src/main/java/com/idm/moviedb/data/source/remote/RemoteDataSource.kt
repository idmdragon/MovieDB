package com.idm.moviedb.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.source.remote.response.movie.MovieResponse
import com.idm.moviedb.data.source.remote.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.source.remote.response.tv.TvResponse
import com.idm.moviedb.data.source.remote.response.tv.detail.TvDetailResponse
import com.idm.moviedb.utils.Constant
import com.idm.moviedb.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiService: ApiService) {


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

    fun getTvPopular(): LiveData<ApiResponse<TvResponse>> {
        EspressoIdlingResource.increment()
        val listTvPopular = MutableLiveData<ApiResponse<TvResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTvPopular(Constant.API_KEY)
            if (response.isSuccessful) {
                listTvPopular.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()

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
                Log.d("getDetailMovie","isi ${response.body()}")
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
                Log.d("getDetailTv", "isi ${response.body()}")

            } else {
                detailTv.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return detailTv
    }

}