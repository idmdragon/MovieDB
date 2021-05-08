package com.idm.moviedb.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDetailResponse)

    @Delete
    suspend fun deleteMovie(movie: MovieDetailResponse)

    @Query("SELECT * from movie_item")
    fun observeAllMovieItems(): LiveData<List<MovieDetailResponse>>

    @Query("SELECT * FROM movie_item WHERE id = :id")
    fun getMovieItem(id: Int): LiveData<MovieDetailResponse>

}