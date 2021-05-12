package com.idm.moviedb.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse

@Dao
interface MovieDao {

    @Query("SELECT * From movie_toprated")
    fun getTopRated(): DataSource.Factory<Int, MovieTopRated>

    @Query("SELECT * From movie_list")
    fun getNowPlaying(): DataSource.Factory<Int, MovieResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListMovie(movie: ArrayList<MovieResult>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListMovieTopRated(movie: ArrayList<MovieTopRated>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: MovieDetailResponse)

    @Delete
    suspend fun deleteMovie(movie: MovieDetailResponse)

    @Query("SELECT * from movie_item")
    fun getFavoritesAllMovieItems():  DataSource.Factory<Int, MovieDetailResponse>

    @Query("SELECT * FROM movie_item WHERE id = :id")
    fun getMovieItem(id: Int): LiveData<MovieDetailResponse>



}