package com.idm.moviedb.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

import com.idm.moviedb.data.source.local.dao.MovieDao
import com.idm.moviedb.data.source.local.dao.TvDao
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.local.entity.TvEntity


@Database(
    entities = [
    MovieEntity::class,TvEntity::class],
    version = 1
)
abstract class MovieTvItemDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
}
