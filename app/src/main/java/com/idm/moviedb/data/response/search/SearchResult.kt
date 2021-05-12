package com.idm.moviedb.data.response.search

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_list")
data class SearchResult(
    @PrimaryKey
    val id: Int,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
)