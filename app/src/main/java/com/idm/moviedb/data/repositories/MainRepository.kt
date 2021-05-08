package com.idm.moviedb.data.source.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.local.MovieDao
import com.idm.moviedb.data.source.local.TvDao
import com.idm.moviedb.data.source.remote.ApiService
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import com.idm.moviedb.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val movieDao: MovieDao,
    private val tvDao: TvDao
) : DataSource {

    companion object{
        const val TAG = "MainRepository"
    }

    override fun getTopRated(): LiveData<ArrayList<MovieResult>> {
        EspressoIdlingResource.increment()
        val listTopRated = MutableLiveData<ArrayList<MovieResult>>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTopRated(API_KEY)
            if (response.isSuccessful) {
                listTopRated.postValue(response.body()?.results)
                EspressoIdlingResource.decrement()

            } else {
                Log.e(TAG, "getTopRated Response Fail")
            }
        }
        return listTopRated
    }

    override fun getNowPlaying(): LiveData<ArrayList<MovieResult>> {
        EspressoIdlingResource.increment()
        val listNowPlaying = MutableLiveData<ArrayList<MovieResult>>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getNowPlaying(API_KEY)
            if (response.isSuccessful) {
                listNowPlaying.postValue(response.body()?.results)
                EspressoIdlingResource.decrement()
            } else {
                Log.e(TAG, "getNowPlaying Response Fail")
            }
        }
        return listNowPlaying
    }

    override fun movieSearch(query: String): LiveData<ArrayList<SearchResult>> {
        val searchItemList = MutableLiveData<ArrayList<SearchResult>>()
        EspressoIdlingResource.increment()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.movieSearch(API_KEY, query)
            if (response.isSuccessful) {
                searchItemList.postValue(response.body()?.results)
                EspressoIdlingResource.decrement()
            } else {
                Log.e(TAG, "movieSearch Response Fail")
            }
        }
        return searchItemList
    }

    override fun getTvPopular(): LiveData<ArrayList<TvResult>> {
        EspressoIdlingResource.increment()
        val listTvPopular = MutableLiveData<ArrayList<TvResult>>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getTvPopular(API_KEY)
            if (response.isSuccessful) {
                listTvPopular.postValue(response.body()?.results)
                EspressoIdlingResource.decrement()
            } else {
                Log.e(TAG, "getTvPopular Response Fail")
            }
        }
        return listTvPopular
    }

    override fun getDetailMovie(movie_id: Int): LiveData<MovieDetailResponse> {
        EspressoIdlingResource.increment()
        val detailMovie = MutableLiveData<MovieDetailResponse>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailMovie(movie_id, API_KEY)
            if (response.isSuccessful) {
                detailMovie.postValue(response.body())
                EspressoIdlingResource.decrement()
            } else {
                Log.e(TAG, "getDetailMovie Response Fail")
            }
        }
        return detailMovie
    }

    override fun getDetailTv(tv_id: Int): LiveData<TvDetailResponse> {
        EspressoIdlingResource.increment()
        val detailTv = MutableLiveData<TvDetailResponse>()

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailTv(tv_id, API_KEY)
            if (response.isSuccessful) {
                detailTv.postValue(response.body())
                EspressoIdlingResource.decrement()
            } else {
                Log.e(TAG, "getDetailTv Response Fail")
            }
        }
        return detailTv
    }

    // Movie
    override suspend fun insertMovie(movie: MovieDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.insertMovie(movie)
        }
    }

    override suspend fun deleteMovie(movie: MovieDetailResponse) {

        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteMovie(movie)
        }
    }

    override fun observeAllMovieItems(): LiveData<List<MovieDetailResponse>> {
        return movieDao.observeAllMovieItems()
    }

    override fun getMovieItem(id: Int): LiveData<MovieDetailResponse> {
        return movieDao.getMovieItem(id)
    }

    // TV
    override suspend fun insertTv(tv: TvDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.insertTv(tv)
        }
    }

    override suspend fun deleteTv(tv: TvDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteTv(tv)
        }
    }

    override fun observeAllTvItems(): LiveData<List<TvDetailResponse>> {
        return tvDao.observeAllTvItems()
    }

    override fun getTvItem(id: Int): LiveData<TvDetailResponse> {
        return tvDao.getTvItem(id)
    }
}

