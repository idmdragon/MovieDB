package com.idm.moviedb.data.source.local

import androidx.paging.DataSource
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.remote.ApiService
import javax.inject.Inject
class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val tvDao: TvDao,
        ){

    //Movie TopRated
    fun getTopRated() : DataSource.Factory<Int, MovieTopRated> = movieDao.getTopRated()
    suspend fun insertTopRatedMovies(listMovie: ArrayList<MovieTopRated>)= movieDao.insertListMovieTopRated(listMovie)


    //Movie Now Playing
    fun getNowPlaying() : DataSource.Factory<Int, MovieResult>  = movieDao.getNowPlaying()
    suspend fun insertNowPlayingMovies(listMovie: ArrayList<MovieResult>)= movieDao.insertListMovie(listMovie)

    //Movie Search
    fun getSearchMovie() : DataSource.Factory<Int, SearchResult>  = movieDao.getSearchMovie()
    suspend fun insertSearchMovie(listMovie: ArrayList<SearchResult>)= movieDao.insertSearchMovie(listMovie)

    //TV Popular
    fun getTvPopular() : DataSource.Factory<Int, TvResult>  = tvDao.getTvPopular()
    suspend fun insertTvPopular(listTv: ArrayList<TvResult>)= tvDao.insertListTv(listTv)

    //Favorite Movie
    suspend fun insertFavoriteMovie(movie: MovieDetailResponse) = movieDao.insertFavoriteMovie(movie)
    suspend fun deleteMovie(movie: MovieDetailResponse) = movieDao.deleteMovie(movie)
    fun getAllFavoriteMovieItems() = movieDao.getFavoritesAllMovieItems()
    fun getMovieItem(id: Int) = movieDao.getMovieItem(id)


    //Favorite Tv
    suspend fun insertTv(tv: TvDetailResponse) = tvDao.insertFavoriteTv(tv)
    suspend fun deleteTv(tv: TvDetailResponse) = tvDao.deleteTv(tv)
    fun getAllFavoriteTVItems() = tvDao.getAllFavoriteTvItems()
    fun getTvItem(id: Int) = tvDao.getTvItem(id)

}
