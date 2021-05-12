package com.idm.moviedb.utils.dummyData

import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.Genre
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse

object DummyMovie {
    fun generateTopMovie(): ArrayList<MovieResult> {
        val movies = ArrayList<MovieResult>()
        movies.add(
            MovieResult(
                backdrop_path = "/xRI636TOdS1K1GBqIBRSmfZ1T5x.jpg",
                id = 19404,
                vote_average = 8.7,
                poster_path = "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
                release_date = "1995-10-20",
                title = "Dilwale Dulhania Le Jayenge"
            )
        )
        return movies
    }

    fun generateNowPlaying(): ArrayList<MovieResult> {
        val movies = ArrayList<MovieResult>()
        movies.add(
            MovieResult(
                backdrop_path = "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                id = 399566,
                vote_average = 8.3,
                poster_path = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                release_date = "2021-03-24",
                title = "Godzilla vs. Kong"
            )
        )
        return movies
    }

    fun generateTopMovieDetail(): MovieDetailResponse {
        val movie = MovieDetailResponse(
            backdrop_path = "/xRI636TOdS1K1GBqIBRSmfZ1T5x.jpg",
            budget = 13200000,
            genres = listOf(
                Genre("Comedy"), Genre("Drama"),
                Genre("Romance")
            ),
            id = 19404,
            original_language = "hi",
            original_title = "दिलवाले दुल्हनिया ले जायेंगे",
            overview = "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
            poster_path = "/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
            release_date = "1995-10-20",
            revenue = 100000000,
            status = "Released",
            tagline = "Come Fall In love, All Over Again..",
            title = "Dilwale Dulhania Le Jayenge",
            vote_average = 8.7

        )
        return movie
    }

    fun generateNowPlayingMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            backdrop_path = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            budget = 20000000,
            genres = listOf(
                Genre("Fantasy"),
                Genre("Action"),
                Genre("Adventure"),
                Genre("Science Fiction"),
                Genre("Thriller")
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