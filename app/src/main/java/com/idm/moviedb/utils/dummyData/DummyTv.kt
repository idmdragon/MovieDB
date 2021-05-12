package com.idm.moviedb.utils.dummyData

import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.response.tv.detail.Genre
object DummyTv {
    fun generateListTvShow(): ArrayList<TvResult> {
        val tvShow = ArrayList<TvResult>()
        tvShow.add(
            TvResult(
                backdrop_path = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                first_air_date = "2021-03-19",
                id = 88396,
                name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                poster_path = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                vote_average = 70.9,
            )
        )

        return tvShow
    }

    fun generateTvDetail(): TvDetailResponse {
        return TvDetailResponse(
            backdrop_path = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            genres = listOf(
                Genre("Sci-Fi & Fantasy"),
                Genre("Action & Adventure"),
                Genre("Drama"),
                Genre("War & Politics")
            ),
            id = 88396,
            name ="The Falcon and the Winter Soldier",
            number_of_episodes = 6,
            overview ="Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            poster_path = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            status="Ended",
            tagline="Honor the shield.",
            vote_average=7.9
        )
    }
}