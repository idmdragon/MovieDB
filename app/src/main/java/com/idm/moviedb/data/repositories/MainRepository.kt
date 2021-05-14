package com.idm.moviedb.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.room.PrimaryKey
import com.idm.moviedb.data.NetworkBoundResource
import com.idm.moviedb.data.source.remote.response.movie.MovieResponse
import com.idm.moviedb.data.source.remote.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.source.remote.response.tv.TvResponse
import com.idm.moviedb.data.source.remote.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.local.LocalDataSource
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.data.source.remote.ApiResponse
import com.idm.moviedb.data.source.remote.RemoteDataSource
import com.idm.moviedb.data.source.remote.response.movie.detail.Genres
import com.idm.moviedb.data.source.remote.response.tv.detail.Genre
import com.idm.moviedb.utils.Constant
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

    override fun getNowPlaying(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, MovieResponse>() {

            val listNowPlayingMovie = ArrayList<MovieEntity>()
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovieList(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<MovieResponse>> =
                remoteDataSource.getNowPlaying()

            override fun saveCallResult(data: MovieResponse) {
                for (item in data.results) {
                    val movieItem = MovieEntity(
                        item.backdrop_path,
                        0,
                        genres = listOf(
                            Genres(""),
                        ),
                        item.id,
                        "",
                        "",
                        "",
                        item.poster_path,
                        item.release_date,
                        0,
                        "",
                        "",
                        item.title,
                        item.vote_average,
                        false

                    )
                    listNowPlayingMovie.add(movieItem)
                }
                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.insertMovieList(listNowPlayingMovie)
                }
            }
        }.asLiveData()
    }

    override fun getTvPopular(): LiveData<Resource<PagedList<TvEntity>>> {
        return object : NetworkBoundResource<PagedList<TvEntity>, TvResponse>() {

            val listTvItem = ArrayList<TvEntity>()
            override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                val config = PagedList.Config.Builder()
                    .setInitialLoadSizeHint(10)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvList(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<TvResponse>> =
                remoteDataSource.getTvPopular()

            override fun saveCallResult(data: TvResponse) {
                for (item in data.results) {
                    val tvitem = TvEntity(
                       item.backdrop_path,
                        genres = listOf(
                            Genre(""),
                        ),
                        item.id,
                        item.name,
                        0,
                        item.overview,
                        item.poster_path,
                        "",
                        "",
                        item.vote_average,
                        item.first_air_date,
                        false

                    )


                    listTvItem.add(tvitem)
                }
                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.insertTvList(listTvItem)
                }
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movie_id: Int): LiveData<Resource<MovieEntity>> {

        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>() {
            val listNowPlayingMovie = ArrayList<MovieEntity>()
            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getDetailMovie(movie_id)
            }

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null || data.status.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getDetailMovie(movie_id)

            override fun saveCallResult(data: MovieDetailResponse) {
                val movieItem = MovieEntity(
                    data.backdrop_path,
                    data.budget,
                    data.genres,
                    data.id,
                    data.original_language,
                    data.original_title,
                    data.overview,
                    data.poster_path,
                    data.release_date,
                    data.revenue,
                    data.status,
                    data.tagline,
                    data.title,
                    data.vote_average,
                    false
                )
                listNowPlayingMovie.add(movieItem)
                Log.d("GetDetailRepo","isi movieItem $movieItem")

                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.insertMovieList(listNowPlayingMovie)
                }

            }
        }.asLiveData()
    }

    override fun getDetailTv(tv_id: Int): LiveData<Resource<TvEntity>> {
        return object : NetworkBoundResource<TvEntity, TvDetailResponse>() {
            val listTvItem = ArrayList<TvEntity>()
            override fun loadFromDB(): LiveData<TvEntity> {
                return localDataSource.getDetailTv(tv_id)
            }

            override fun shouldFetch(data: TvEntity?): Boolean =
                data == null || data.status.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<TvDetailResponse>> =
                remoteDataSource.getDetailTv(tv_id)

            override fun saveCallResult(data: TvDetailResponse) {
                val tvitem = TvEntity(
                    data.backdrop_path,
                    data.genres,
                    data.id,
                    data.name,
                    data.number_of_episodes,
                    data.overview,
                    data.poster_path,
                    data.status,
                    data.tagline,
                    data.vote_average,
                    data.first_air_date,
                    false
                )
               listTvItem.add(tvitem)
               Log.d("GetDetailRepo","isi Tvitem $tvitem")
                CoroutineScope(Dispatchers.IO).launch {
                    localDataSource.insertTvList(listTvItem)
                }

            }
        }.asLiveData()
    }

    override suspend fun updateMovie(movie: MovieEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.updateMovie(movie)
        }
    }

    override fun getAllFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteMovieItems(), config).build()
    }

    override suspend fun updateTv(tv: TvEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.updateTv(tv)
        }
    }

    override fun getAllFavoriteTv(): LiveData<PagedList<TvEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteTVItems(), config).build()
    }
}

