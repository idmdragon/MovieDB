package com.idm.moviedb.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.vo.Resource

@Dao
interface TvDao {

    @Query("SELECT * From tv_list")
    fun getTvPopular(): DataSource.Factory<Int, TvResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListTv(movie: ArrayList<TvResult>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteTv(tv: TvDetailResponse)

    @Delete
    suspend fun deleteTv(tv: TvDetailResponse)

    @Query("SELECT * from tv_item")
    fun getAllFavoriteTvItems(): DataSource.Factory<Int, TvDetailResponse>


    @Query("SELECT * FROM tv_item WHERE id = :id")
    fun getTvItem(id: Int): LiveData<TvDetailResponse>

}