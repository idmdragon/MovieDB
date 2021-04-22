package com.idm.moviedb.data.source.repositories

import androidx.lifecycle.LiveData
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.models.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.models.search.SearchResponse
import com.idm.moviedb.data.models.search.SearchResult
import com.idm.moviedb.data.models.tv.TvResult
import com.idm.moviedb.data.models.tv.detail.TvDetailResponse
import retrofit2.Response


class FakeMainRepository constructor():DataSource{
    override suspend fun getTopRated(): LiveData<ArrayList<MovieResult>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNowPlaying(): LiveData<ArrayList<MovieResult>> {
        TODO("Not yet implemented")
    }

    override suspend fun movieSearch(query: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getTvPopular(): LiveData<ArrayList<TvResult>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailMovie(movie_id: Int): LiveData<MovieDetailResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailTv(tv_id: Int): LiveData<TvDetailResponse> {
        TODO("Not yet implemented")
    }
}