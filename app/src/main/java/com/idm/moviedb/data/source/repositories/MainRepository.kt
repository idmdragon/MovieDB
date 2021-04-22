package com.idm.moviedb.data.source.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.models.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.models.search.SearchResponse
import com.idm.moviedb.data.models.search.SearchResult
import com.idm.moviedb.data.models.tv.TvResult
import com.idm.moviedb.data.models.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.remote.ApiService
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) : DataSource {

    override suspend fun getTopRated(): LiveData<ArrayList<MovieResult>> {
        val _listTopRated = MutableLiveData<ArrayList<MovieResult>>()
        val listTopRated: LiveData<ArrayList<MovieResult>> = _listTopRated

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTopRated(API_KEY)
            if (response.isSuccessful) {
                _listTopRated.postValue(response.body()?.results)
            } else {
                Log.e("MainRepository", "getTopRated response fail")
            }
        }
        return listTopRated
    }

    override suspend fun getNowPlaying(): LiveData<ArrayList<MovieResult>> {
        val _listNowPlaying = MutableLiveData<ArrayList<MovieResult>>()
        val listNowPlaying: LiveData<ArrayList<MovieResult>> = _listNowPlaying

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getNowPlaying(API_KEY)
            if (response.isSuccessful) {
                _listNowPlaying.postValue(response.body()?.results)
            } else {
                Log.e("MainRepository", "getNowPlaying response fail")
            }
        }
        return listNowPlaying
    }

    private val _searchItemList = MutableLiveData<ArrayList<SearchResult>>()
    private val searchItemList : LiveData<ArrayList<SearchResult>> = _searchItemList

    override suspend fun movieSearch(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.movieSearch(API_KEY, query)
            if (response.isSuccessful) {
                _searchItemList.postValue(response.body()?.results)
            } else {
                Log.e("MainRepository", "movieSearch response fail")
            }
        }
    }

    fun getSearchItemList(): LiveData<ArrayList<SearchResult>> {
        return searchItemList
    }


    override suspend fun getTvPopular(): LiveData<ArrayList<TvResult>> {
        val _listTvPopular = MutableLiveData<ArrayList<TvResult>>()
        val listTvPopular: LiveData<ArrayList<TvResult>> = _listTvPopular

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTvPopular(API_KEY)
            if (response.isSuccessful) {
                _listTvPopular.postValue(response.body()?.results)
            } else {
                Log.e("MainRepository", "getTvPopular response fail")
            }
        }
        return listTvPopular
    }

    override suspend fun getDetailMovie(movie_id: Int): LiveData<MovieDetailResponse> {
        val _detailMovie = MutableLiveData<MovieDetailResponse>()
        val detailMovie: LiveData<MovieDetailResponse> = _detailMovie

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailMovie(movie_id, API_KEY)
            if (response.isSuccessful) {
                _detailMovie.postValue(response.body())
            } else {
                Log.e("MainRepository", "getDetailMovie response fail")
            }
        }
        return detailMovie
    }

    override suspend fun getDetailTv(tv_id: Int): LiveData<TvDetailResponse> {
        val _detailTv = MutableLiveData<TvDetailResponse>()
        val detailTv: LiveData<TvDetailResponse> = _detailTv

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailTv(tv_id, API_KEY)
            if (response.isSuccessful) {
                _detailTv.postValue(response.body())
            } else {
                Log.e("MainRepository", "getDetailTv response fail")
            }
        }
        return detailTv
    }
}

