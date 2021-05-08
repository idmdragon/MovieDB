package com.idm.moviedb.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse

@Dao
interface TvDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTv(tv: TvDetailResponse)

    @Delete
    suspend fun deleteTv(tv: TvDetailResponse)

    @Query("SELECT * from tv_item")
    fun observeAllTvItems(): LiveData<List<TvDetailResponse>>

    @Query("SELECT * FROM tv_item WHERE id = :id")
    fun getTvItem(id: Int): LiveData<TvDetailResponse>

}