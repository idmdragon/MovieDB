package com.idm.moviedb.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.idm.moviedb.data.source.local.entity.TvEntity

@Dao
interface TvDao {
    @Query("SELECT * From tv_list")
    fun getTvList(): DataSource.Factory<Int, TvEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListTv(movie: ArrayList<TvEntity>)

    @Update(entity = TvEntity::class)
    fun updateTv(tv: TvEntity)

    @Query("SELECT * from tv_list where favorite = 1 ")
    fun getAllFavoriteTvItems(): DataSource.Factory<Int, TvEntity>

    @Query("SELECT * FROM tv_list where id = :id")
    fun getDetailTv(id: Int): LiveData<TvEntity>
}