package com.idm.moviedb.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.room.PrimaryKey
import com.idm.moviedb.data.NetworkBoundResource
import com.idm.moviedb.data.response.movie.MovieResponse
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.movie.toprated.MovieTopRatedResponse
import com.idm.moviedb.data.response.search.SearchResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResponse
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.local.LocalDataSource
import com.idm.moviedb.data.source.remote.ApiResponse
import com.idm.moviedb.data.source.remote.RemoteDataSource
import com.idm.moviedb.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : MovieTvDataSource {

    companion object {
        const val TAG = "MainRepository"
    }

    override fun movieSearch(query: String): LiveData<Resource<PagedList<SearchResult>>> {
            return object : NetworkBoundResource<PagedList<SearchResult>, SearchResponse>() {

                val listSearchMovie = ArrayList<SearchResult>()
                override fun loadFromDB(): LiveData<PagedList<SearchResult>> {
                    val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()
                    return LivePagedListBuilder(localDataSource.getSearchMovie(), config).build()
                }

                override fun shouldFetch(data: PagedList<SearchResult>?): Boolean =
                    data == null || data.isEmpty()

                public override fun createCall(): LiveData<ApiResponse<SearchResponse>> =
                    remoteDataSource.movieSearch(query)

                override fun saveCallResult(data: SearchResponse) {
                    for (item in data.results){
                        val searchItem = SearchResult(
                            item.id,
                            item.poster_path,
                            item.release_date,
                            item.title,
                            item.vote_average

                        )

                        listSearchMovie.add(searchItem)
                    }
                    CoroutineScope(Dispatchers.IO).launch {
                        localDataSource.insertSearchMovie(listSearchMovie)
                    }
                }
            }.asLiveData()

    }

    override fun getTopRated(): LiveData<Resource<PagedList<MovieTopRated>>> {
         return object : NetworkBoundResource<PagedList<MovieTopRated>, MovieTopRatedResponse>() {

             val listTopRatedMovie = ArrayList<MovieTopRated>()
             override fun loadFromDB(): LiveData<PagedList<MovieTopRated>> {
                 val config = PagedList.Config.Builder()
                     .setEnablePlaceholders(false)
                     .setInitialLoadSizeHint(4)
                     .setPageSize(4)
                     .build()
                 return LivePagedListBuilder(localDataSource.getTopRated(), config).build()
             }

             override fun shouldFetch(data: PagedList<MovieTopRated>?): Boolean =
                 data == null || data.isEmpty()

             public override fun createCall(): LiveData<ApiResponse<MovieTopRatedResponse>> =
                 remoteDataSource.getTopRated()

             override fun saveCallResult(data: MovieTopRatedResponse) {
                    for (item in data.results){
                        val movieItem = MovieTopRated(
                            item.backdrop_path,
                            item.id,
                            item.poster_path,
                            item.title
                        )
                        listTopRatedMovie.add(movieItem)
                    }
                 CoroutineScope(Dispatchers.IO).launch {
                     localDataSource.insertTopRatedMovies(listTopRatedMovie)
                 }

                 }
             }.asLiveData()
         }


    override fun getNowPlaying(): LiveData<Resource<PagedList<MovieResult>>> {
        return object : NetworkBoundResource<PagedList<MovieResult>, MovieResponse>() {

            val listNowPlayingMovie = ArrayList<MovieResult>()
            override fun loadFromDB(): LiveData<PagedList<MovieResult>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getNowPlaying(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieResult>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getNowPlaying()

            override fun saveCallResult(data: MovieResponse) {
                for (item in data.results){
                    val movieItem = MovieResult(
                        item.backdrop_path,
                        item.id,
                        item.vote_average,
                        item.poster_path,
                        item.release_date,
                        item.title
                    )
                    listNowPlayingMovie.add(movieItem)
                }
                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.insertNowPlayingMovies(listNowPlayingMovie)
                }
            }
        }.asLiveData()
    }

    override fun getTvPopular(): LiveData<Resource<PagedList<TvResult>>> {
        return object : NetworkBoundResource<PagedList<TvResult>, TvResponse>() {

            val listTopRatedMovie = ArrayList<TvResult>()
            override fun loadFromDB(): LiveData<PagedList<TvResult>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvPopular(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvResult>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<TvResponse>> =
                remoteDataSource.getTvPopular()

            override fun saveCallResult(data: TvResponse) {
                for (item in data.results){
                    val tvitem = TvResult(
                         item.backdrop_path,
                    item.first_air_date,
                        item.id, item.name,
                    item.overview,
                    item.poster_path,
                        item.vote_average
                    )
                    listTopRatedMovie.add(tvitem)
                }
                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.insertTvPopular(listTopRatedMovie)
                }
            }
        }.asLiveData()
    }



    override fun getDetailMovie(movie_id: Int): LiveData<ApiResponse<MovieDetailResponse>>   = remoteDataSource.getDetailMovie(movie_id)

    override fun getDetailTv(tv_id: Int): LiveData<ApiResponse<TvDetailResponse>> = remoteDataSource.getDetailTv(tv_id)
//    override fun getTopRated(): LiveData<ArrayList<MovieResult>> {
//        EspressoIdlingResource.increment()
//        val listTopRated = MutableLiveData<ArrayList<MovieResult>>()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = apiService.getTopRated(API_KEY)
//            if (response.isSuccessful) {
//                listTopRated.postValue(response.body()?.results)
//                EspressoIdlingResource.decrement()
//
//            } else {
//                Log.e(TAG, "fun getTopRated -> Response Code : ${response.code()}")
//            }
//        }
//        return listTopRated
//    }
//
//    override fun getNowPlaying(): LiveData<ArrayList<MovieResult>> {
//        EspressoIdlingResource.increment()
//        val listNowPlaying = MutableLiveData<ArrayList<MovieResult>>()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = apiService.getNowPlaying(API_KEY)
//            if (response.isSuccessful) {
//                listNowPlaying.postValue(response.body()?.results)
//                EspressoIdlingResource.decrement()
//            } else {
//                Log.e(TAG, "fun getNowPlaying -> Response Code : ${response.code()}")
//            }
//        }
//        return listNowPlaying
//    }
//
//    override fun movieSearch(query: String): DataSource.Factory<Int, SearchResult>   {
//        val searchItemList = MutableLiveData<ArrayList<SearchResult>>()
//        EspressoIdlingResource.increment()
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = apiService.movieSearch(API_KEY, query)
//            if (response.isSuccessful) {
//                searchItemList.postValue(response.body()?.results)
//                EspressoIdlingResource.decrement()
//            } else {
//                Log.e(TAG, "fun movieSearch -> Response Code : ${response.code()}")
//            }
//        }
//        return searchItemList
//    }
//
//    override fun getTvPopular(): LiveData<ArrayList<TvResult>> {
//        EspressoIdlingResource.increment()
//        val listTvPopular = MutableLiveData<ArrayList<TvResult>>()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = apiService.getTvPopular(API_KEY)
//            if (response.isSuccessful) {
//                listTvPopular.postValue(response.body()?.results)
//                EspressoIdlingResource.decrement()
//            } else {
//                Log.e(TAG, "fun getTvPopular -> Response Code : ${response.code()}")
//            }
//        }
//        return listTvPopular
//    }
//
//    override fun getDetailMovie(movie_id: Int): LiveData<MovieDetailResponse> {
//        EspressoIdlingResource.increment()
//        val detailMovie = MutableLiveData<MovieDetailResponse>()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = apiService.getDetailMovie(movie_id, API_KEY)
//            if (response.isSuccessful) {
//                detailMovie.postValue(response.body())
//                EspressoIdlingResource.decrement()
//            } else {
//                Log.e(TAG, "fun getDetailMovie -> Response Code : ${response.code()}")
//            }
//        }
//        return detailMovie
//    }
//
//    override fun getDetailTv(tv_id: Int): LiveData<TvDetailResponse> {
//        EspressoIdlingResource.increment()
//        val detailTv = MutableLiveData<TvDetailResponse>()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = apiService.getDetailTv(tv_id, API_KEY)
//            if (response.isSuccessful) {
//                detailTv.postValue(response.body())
//                EspressoIdlingResource.decrement()
//            } else {
//                Log.e(TAG, "fun getDetailTV -> Response Code : ${response.code()}")
//            }
//        }
//        return detailTv
//    }

    // Movie
    override suspend fun insertMovie(movie: MovieDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertFavoriteMovie(movie)
        }
    }

    override suspend fun deleteMovie(movie: MovieDetailResponse) {

        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteMovie(movie)
        }
    }

    override fun getAllFavoriteMovie(): DataSource.Factory<Int, MovieDetailResponse> {
        return localDataSource.getAllFavoriteMovieItems()
    }

    override fun getMovieItem(id: Int): LiveData<MovieDetailResponse> {
        return localDataSource.getMovieItem(id)
    }

    // TV
    override suspend fun insertTv(tv: TvDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertTv(tv)
        }
    }

    override suspend fun deleteTv(tv: TvDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteTv(tv)
        }
    }

    override fun getAllFavoriteTv(): DataSource.Factory<Int, TvDetailResponse> {
        return localDataSource.getAllFavoriteTVItems()
    }

    override fun getTvItem(id: Int): LiveData<TvDetailResponse> {
        return localDataSource.getTvItem(id)
    }
}

