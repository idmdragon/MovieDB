package com.idm.moviedb.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.IdlingRegistry
import com.idm.moviedb.utils.DummyMovie
import com.idm.moviedb.utils.EspressoIdlingResource
import org.junit.After
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.idm.moviedb.R
import com.idm.moviedb.utils.DummyMovie.generateNowPlayingMovie
import com.idm.moviedb.utils.DummyMovie.generateTopMovieDetail
import com.idm.moviedb.utils.DummyTv
import org.junit.Before
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class HomeActivityTest {

        private val dummyTopMovie = DummyMovie.generateTopMovie()
        private val dummyNowPlaying = DummyMovie.generateNowPlaying()
        private val dummyTvPopular = DummyTv.generateListTvShow()

        @Before
        fun setUp() {
            IdlingRegistry.getInstance()
                .register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
            ActivityScenario.launch(HomeActivity::class.java)
        }

        @After
        fun tearDown() {
            IdlingRegistry.getInstance()
                .unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
        }

        @Test
        fun loadTopMovies() {
            onView(withId(R.id.rv_top)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_top)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTopMovie.size))
            onView(withId(R.id.rv_tvshow)).check(doesNotExist())
        }
        @Test
        fun loadNowPlaying() {
            onView(withId(R.id.rv_np)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_np)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyNowPlaying.size))
            onView(withId(R.id.rv_tvshow)).check(doesNotExist())
        }
        @Test
        fun loadTvShow() {
            onView(withId(R.id.tv)).perform(click());
            onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvPopular.size))
            onView(withId(R.id.rv_top)).check(doesNotExist())
            onView(withId(R.id.rv_np)).check(doesNotExist())
        }

        @Test
        fun detailMovieTop(){
            val position = 0
            onView(withId(R.id.rv_top)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click()))
            val dummyMovie = generateTopMovieDetail()
            val listGenre  = dummyMovie.genres.map {
                it.name
            }
            val genre = listGenre.joinToString()
            val budget = dummyMovie.budget
            val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
            val revenue = dummyMovie.revenue
            val convertRevenue = NumberFormat.getNumberInstance(Locale.US).format(revenue)

            onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
            onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_tittle)).check(matches(isDisplayed()))
            onView(withId(R.id.tvTagline)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_star)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_status)).check(matches(withText(dummyMovie.status)))
            onView(withId(R.id.tv_tittle)).check(matches(withText(dummyMovie.title)))
            onView(withId(R.id.tvBudget)).check(matches(withText(convertBudget)))
            onView(withId(R.id.tvRevenue)).check(matches(withText(convertRevenue)))
            onView(withId(R.id.tv_star)).check(matches(withText(dummyMovie.vote_average.toString())))
            onView(withId(R.id.tvGenre)).check(matches(withText(genre)))
            onView(withId(R.id.tvTagline)).check(matches(withText(dummyMovie.tagline)))
            onView(withId(R.id.tv_storyline)).check(matches(withText(dummyMovie.overview)))
        }

    @Test
    fun detailMovieNowPlaying(){
        val position = 0
        onView(withId(R.id.rv_np)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click()))
        val dummyMovie = generateNowPlayingMovie()
        val listGenre  = dummyMovie.genres.map {
            it.name
        }
        val genre = listGenre.joinToString()
        val budget = dummyMovie.budget
        val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
        val revenue = dummyMovie.revenue
        val convertRevenue = NumberFormat.getNumberInstance(Locale.US).format(revenue)

        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tittle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_star)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyMovie.status)))
        onView(withId(R.id.tv_tittle)).check(matches(withText(dummyMovie.title)))
        onView(withId(R.id.tvBudget)).check(matches(withText(convertBudget)))
        onView(withId(R.id.tvRevenue)).check(matches(withText(convertRevenue)))
        onView(withId(R.id.tv_star)).check(matches(withText(dummyMovie.vote_average.toString())))
        onView(withId(R.id.tvGenre)).check(matches(withText(genre)))
        onView(withId(R.id.tvTagline)).check(matches(withText(dummyMovie.tagline)))
        onView(withId(R.id.tv_storyline)).check(matches(withText(dummyMovie.overview)))
    }


    }