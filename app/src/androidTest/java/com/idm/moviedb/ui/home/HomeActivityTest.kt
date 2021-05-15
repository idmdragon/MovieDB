package com.idm.moviedb.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.IdlingRegistry
import com.idm.moviedb.utils.EspressoIdlingResource
import org.junit.After
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.idm.moviedb.R
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

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
    fun moviesPage() {
        val position = 0
        onView(withId(R.id.rv_np)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_np)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )
        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tittle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_star)).check(matches(isDisplayed()))
        onView(isRoot()).perform(ViewActions.swipeUp())
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_storyline)).check(matches(isDisplayed()))
        onView(isRoot()).perform(ViewActions.swipeDown())
        onView(withId(R.id.btnBack)).perform(click())

    }

    @Test
    fun tvShow() {
        onView(withId(R.id.tv)).perform(click())
        val position = 0
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                10
            )
        )
        onView(withId(R.id.rv_tvshow)).perform()
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )
        onView(withId(R.id.tvStatus)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tittle)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tvStatus)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_star)).check(matches(isDisplayed()))
        onView(isRoot()).perform(ViewActions.swipeUp())
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvStoryline)).check(matches(isDisplayed()))
        onView(isRoot()).perform(ViewActions.swipeDown())
        onView(withId(R.id.btn_back)).perform(click())

    }

    @Test
    fun favoriteInsertDelete(){
        onView(withId(R.id.favorite)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.movies)).perform(click())
        onView(withId(R.id.rv_np)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_np)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btnSave)).perform(click())
        onView(withId(R.id.btnBack)).perform(click())
        onView(withId(R.id.tv)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.btn_back)).perform(click())
        onView(withId(R.id.favorite)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_fav_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btnSave)).perform(click())
        onView(withId(R.id.btnBack)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_fav_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.btn_back)).perform(click())
        onView(withText("TV Show")).perform(click())

    }


    }