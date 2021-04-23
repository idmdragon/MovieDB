package com.idm.moviedb.utils

import com.idm.moviedb.data.models.tv.TvResult
import com.idm.moviedb.data.models.tv.detail.TvDetailResponse
import com.idm.moviedb.data.models.tv.detail.Genre
object DummyTv {
    fun generateListTvShow(): ArrayList<TvResult> {
        val tvShow = ArrayList<TvResult>()
        tvShow.add(
            TvResult(
                backdrop_path = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                first_air_date = "2021-03-19",
                genre_ids = listOf(10765, 10759, 18, 10768),
                id = 88396,
                name = "The Falcon and the Winter Soldier",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                popularity = 3675.832,
                poster_path = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                vote_average = 70.9,
                vote_count = 4426
            )
        )

        tvShow.add(
            TvResult(
                backdrop_path = "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                first_air_date = "2017-09-25",
                genre_ids = listOf(18),
                id = 71712,
                name = "The Good Doctor",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                popularity = 1745.906,
                poster_path = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                vote_average = 8.6,
                vote_count = 8010
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                first_air_date = "2014-10-07",
                genre_ids = listOf(18, 10765),
                id = 60735,
                name = "The Flash",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only ”meta-human” who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                popularity = 1382.037,
                poster_path = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                vote_average = 7.7,
                vote_count = 7407
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                first_air_date = "2021-03-26",
                genre_ids = listOf(16, 10759, 18),
                id = 95557,
                name = "Invincible",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "Invincible",
                overview = "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                popularity = 954.915,
                poster_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                vote_average = 8.9,
                vote_count = 726
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                first_air_date = "2005-03-27",
                genre_ids = listOf(18),
                id = 1416,
                name = "Grey's Anatomy",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "Grey's Anatomy",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                popularity = 887.647,
                poster_path = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                vote_average = 8.2,
                vote_count = 5896
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                first_air_date = "2017-01-26",
                genre_ids = listOf(9648, 18, 80),
                id = 69050,
                name = "Riverdale",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "Riverdale",
                overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                popularity = 898.701,
                poster_path = "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                vote_average = 8.6,
                vote_count = 11057
            )
        )

        tvShow.add(
            TvResult(
                backdrop_path = "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
                first_air_date = "2016-01-25",
                genre_ids = listOf(80, 10765),
                id = 63174,
                name = "Lucifer",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "Lucifer",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                popularity = 765.386,
                poster_path = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                vote_average = 8.5,
                vote_count = 8300
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path =  "/uro2Khv7JxlzXtLb8tCIbRhkb9E.jpg" ,
                first_air_date = "2010-10-31",
                genre_ids = listOf(10759,
                    18,
                    10765),
                id = 1402,
                name = "The Walking Dead",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "The Walking Dead",
                overview = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                popularity = 681.472,
                poster_path = "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                vote_average = 8.1,
                vote_count = 10600
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path =  "/57vVjteucIF3bGnZj6PmaoJRScw.jpg" ,
                first_air_date = "2021-01-15",
                genre_ids = listOf(10765,
                    9648,
                    18),
                id = 85271,
                name = "WandaVision",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "WandaVision",
                overview = "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                popularity = 675.183,
                poster_path = "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                vote_average = 8.4,
                vote_count = 8212
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                first_air_date = "2021-03-19",
                genre_ids = listOf(10765, 10759, 18, 10768),
                id = 88396,
                name = "The Falcon and the Winter Soldier",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                popularity = 3675.832,
                poster_path = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                vote_average = 70.9,
                vote_count = 4426
            )
        )

        tvShow.add(
            TvResult(
                backdrop_path = "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                first_air_date = "2017-09-25",
                genre_ids = listOf(18),
                id = 71712,
                name = "The Good Doctor",
                origin_country = listOf("US"),
                original_language = "en",
                original_name = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                popularity = 1745.906,
                poster_path = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                vote_average = 8.6,
                vote_count = 8010
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/pLG4ihU1d2XkQbASQDjsFu9U7d9.jpg",
                first_air_date = "2021-03-24",
                genre_ids = listOf(
                    18,
                    80,
                    9648
                ),
                id = 120168,
                name = "Who Killed Sara?",
                origin_country = listOf(
                    "MX"
                ),
                original_language = "es",
                original_name = "¿Quién mató a Sara?",
                overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                popularity = 650.411,
                poster_path = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                vote_average = 7.8,
                vote_count = 376
            )
        )

        tvShow.add(
            TvResult(
                backdrop_path = "/TXaR5xmz2ohHgnpf0YPWtZPlCO.jpg",
                first_air_date = "2021-02-23",
                genre_ids = listOf(
                    10759,
                    10765
                ),
                id = 95057,
                name = "Superman & Lois",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "Superman & Lois",
                overview = "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                popularity = 602.783,
                poster_path = "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                vote_average = 8.3,
                vote_count = 744
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/suopoADq0k8YZr4dQXcU6pToj6s.jpg",
                first_air_date = "2011-04-17",
                genre_ids = listOf(
                    10765,
                    18,
                    10759
                ),
                id = 1399,
                name = "Game of Thrones",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "Game of Thrones",
                overview = "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                popularity = 530.205,
                poster_path = "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                vote_average = 8.4,
                vote_count = 14025
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/6xsjdGa2nuc8by10KO6zg8GDZrp.jpg",
                first_air_date = "2018-04-22",
                genre_ids = listOf(
                    18
                ),
                id = 79008,
                name = "Luis Miguel: The Series",
                origin_country = listOf(
                    "MX"
                ),
                original_language = "es",
                original_name = "Luis Miguel: La Serie",
                overview = "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                popularity = 754.121,
                poster_path = "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                vote_average = 8.0,
                vote_count = 270
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/58PON1OrnBiX6CqEHgeWKVwrCn6.jpg",
                first_air_date = "2015-08-23",
                genre_ids = listOf(
                    10759,
                    18
                ),
                id = 62286,
                name = "Fear the Walking Dead",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "Fear the Walking Dead",
                overview = "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                popularity = 522.569,
                poster_path = "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
                vote_average = 7.6,
                vote_count = 3402
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/fRYwdeNjMqC30EhofPx5PlDpdun.jpg",
                first_air_date = "2018-10-25",
                genre_ids = listOf(
                    10765,
                    18
                ),
                id = 79460,
                name = "Legacies",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "Legacies",
                overview = "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                popularity = 448.75,
                poster_path = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                vote_average = 8.6,
                vote_count = 1799
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/wgEWTYAAY7F04o4F20j0L1DGB8i.jpg",
                first_air_date = "2019-07-23",
                genre_ids = listOf(
                    18
                ),
                id = 91605,
                name = "I Am...",
                origin_country = listOf(),
                original_language = "en",
                original_name = "I Am...",
                overview =
                "Each hour-long film follows a different women as they experience “moments that are emotionally raw, thought-provoking and utterly personal”.",
                popularity = 393.815,
                poster_path = "/oogunE22HDTcTxFakKQbwqfw1qo.jpg",
                vote_average = 5.4,
                vote_count = 18
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
                first_air_date = "2018-05-02",
                genre_ids = listOf(
                    10759,
                    18
                ),
                id = 77169,
                name = "Cobra Kai",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "Cobra Kai",
                overview = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                popularity = 401.931,
                poster_path = "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                vote_average = 8.1,
                vote_count = 2977
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/oUVXcoUCe0lf3jvJSRpViyebBpc.jpg",
                first_air_date = "2017-07-05",
                genre_ids = listOf(
                    80,
                    18
                ),
                id = 71694,
                name = "Snowfall",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "Snowfall",
                overview = "Los Angeles. 1983. A storm is coming and it's name is crack. Set against the infancy of the crack cocaine epidemic and its ultimate radical impact on the culture as we know it, the story follows numerous characters on a violent collision course.",
                popularity = 354.614,
                poster_path = "/orvFrLzqSeW5qTFpfJEbPfHRPWg.jpg",
                vote_average = 8.1,
                vote_count = 140
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/k7T9xRyzP41wBVNyNeLmh8Ch7gD.jpg",
                first_air_date = "2009-09-10",
                genre_ids = listOf(
                    18,
                    10765
                ),
                id = 18165,
                name = "The Vampire Diaries",
                origin_country = listOf(
                    "US"
                ),
                original_language = "en",
                original_name = "The Vampire Diaries",
                overview = "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
                popularity = 394.663,
                poster_path = "/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg",
                vote_average = 8.3,
                vote_count = 5709
            )
        )
        tvShow.add(
            TvResult(
                backdrop_path = "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg",
                first_air_date = "2013-03-03",
                genre_ids = listOf(
                    10759,
                    18
                ),
                id = 44217,
                name = "Vikings",
                origin_country = listOf(
                    "CA"
                ),
                original_language = "en",
                original_name = "Vikings",
                overview = "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                popularity = 360.581,
                poster_path = "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                vote_average = 8.0,
                vote_count = 4368
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
            number_of_seasons = 1,
            overview ="Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            popularity = 3675.832,
            poster_path = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            status="Ended",
            tagline="Honor the shield.",
            vote_average=7.9
        )
    }
}