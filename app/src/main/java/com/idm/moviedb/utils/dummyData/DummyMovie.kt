package com.idm.moviedb.utils.dummyData

import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.remote.response.movie.detail.Genres

object DummyMovie {

    fun generateNowPlaying(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                backdrop_path = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                budget = 20000000,
                genres = listOf(
                    Genres("Fantasy"),
                    Genres("Action"),
                    Genres("Adventure"),
                    Genres("Science Fiction"),
                    Genres("Thriller")
                ),
                id = 460465,
                original_language = "en",
                original_title = "Mortal Kombat",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                poster_path = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                release_date = "2021-04-07",
                revenue = 50115000,
                status = "Released",
                tagline = "Get over here.",
                title = "Mortal Kombat",
                vote_average = 8.0
            )
        )
        return movies
    }

    fun generateNowPlayingMovie(): MovieEntity {
        return MovieEntity(
            backdrop_path = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            budget = 20000000,
            genres = listOf(
                Genres("Fantasy"),
                Genres("Action"),
                Genres("Adventure"),
                Genres("Science Fiction"),
                Genres("Thriller")
            ),
            id = 460465,
            original_language = "en",
            original_title = "Mortal Kombat",
            overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            poster_path = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            release_date = "2021-04-07",
            revenue = 50115000,
            status = "Released",
            tagline = "Get over here.",
            title = "Mortal Kombat",
            vote_average = 8.0
        )
    }


}