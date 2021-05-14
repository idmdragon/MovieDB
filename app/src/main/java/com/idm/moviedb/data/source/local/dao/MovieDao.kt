package com.idm.moviedb.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.idm.moviedb.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * From movie_list")
    fun getMovieList(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListMovie(movie: ArrayList<MovieEntity>)

    @Update
    suspend fun updateMovie(movie: MovieEntity)

    @Query("SELECT * from movie_list  where favorite = 1 ")
    fun getFavoritesAllMovieItems():  DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_list where id = :id")
    fun getDetailMovie(id: Int): LiveData<MovieEntity>


}