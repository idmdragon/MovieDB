package com.idm.moviedb.utils.dummyData

import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.data.source.remote.response.tv.detail.Genre
object DummyTv {
    fun generateListTvShow(): ArrayList<TvEntity> {
        val tvShow = ArrayList<TvEntity>()
        tvShow.add(
            TvEntity(
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
                vote_average=7.9,
                "2021-03-19"
            )
        )

        return tvShow
    }

    fun generateTvDetail(): TvEntity {
        return TvEntity(
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
            vote_average=7.9,
            "2021-03-19"
        )
    }
}