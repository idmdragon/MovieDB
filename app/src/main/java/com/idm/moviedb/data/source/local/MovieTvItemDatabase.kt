package com.idm.moviedb.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse


@Database(
    entities = [
        MovieDetailResponse::class,
        TvDetailResponse::class,
        MovieResult::class,
        TvResult::class,
        MovieTopRated::class],
    version = 1
)
abstract class MovieTvItemDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
}
