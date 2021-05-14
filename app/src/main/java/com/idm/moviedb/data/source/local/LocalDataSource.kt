package com.idm.moviedb.data.source.local

import androidx.paging.DataSource
import com.idm.moviedb.data.source.local.dao.MovieDao
import com.idm.moviedb.data.source.local.dao.TvDao
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.local.entity.TvEntity
import javax.inject.Inject
class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val tvDao: TvDao,
        ){


    fun getMovieList() : DataSource.Factory<Int, MovieEntity>  = movieDao.getMovieList()
    suspend fun insertMovieList(listMovie: ArrayList<MovieEntity>)= movieDao.insertListMovie(listMovie)
    suspend fun updateMovie(movie: MovieEntity) {
        movie.favorite = !movie.favorite
        movieDao.updateMovie(movie)
    }
    fun getAllFavoriteMovieItems() = movieDao.getFavoritesAllMovieItems()
    fun getDetailTv(tvId : Int) = tvDao.getDetailTv(tvId)


    suspend fun insertTvList(listTv: ArrayList<TvEntity>)= tvDao.insertListTv(listTv)
    fun getTvList() : DataSource.Factory<Int, TvEntity>  = tvDao.getTvList()
    fun getDetailMovie(movieId : Int) = movieDao.getDetailMovie(movieId)
    suspend fun updateTv(tv: TvEntity) {
        tv.favorite = !tv.favorite
        tvDao.updateTv(tv)
    }
    fun getAllFavoriteTVItems() = tvDao.getAllFavoriteTvItems()


}
