package com.idm.moviedb.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.idm.moviedb.R
import com.idm.moviedb.utils.Dummy
import org.junit.Before
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class HomeActivityTest(){

    private val dummyMovies = Dummy.getMovie()
    private val dummyTvShow = Dummy.getTvShow()
    @Before
    fun set(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovie() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        Espresso.onView(withId(R.id.rv_tvshow)).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun loadTVShow() {
        Espresso.onView(withText("TV Show")).perform(click())
        Espresso.onView(withId(R.id.rv_tvshow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
        Espresso.onView(withId(R.id.rv_movies)).check(ViewAssertions.doesNotExist())
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        Espresso.onView(withId(R.id.iv_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_tittle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_tittle))
            .check(ViewAssertions.matches(withText(dummyMovies[0].title)))
        Espresso.onView(withId(R.id.tv_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_genre))
            .check(ViewAssertions.matches(withText(dummyMovies[0].genre)))
        Espresso.onView(withId(R.id.tvDirector))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvDirector))
            .check(ViewAssertions.matches(withText(dummyMovies[0].directors)))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(ViewAssertions.matches(withText(dummyMovies[0].storyLine)))

        //Convert Value of Star
        val star = dummyMovies[0].star.toDouble().div(10)
        Espresso.onView(withId(R.id.tv_star))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_star))
            .check(ViewAssertions.matches(withText(star.toString())))

        //Convert Value of Budget
        val budget = dummyMovies[0].budget
        val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
        Espresso.onView(withId(R.id.tvBudget))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvBudget))
            .check(ViewAssertions.matches(withText(convertBudget)))
    }

    @Test
    fun loadDetailTVShow() {
        Espresso.onView(withText("TV Show")).perform(click())
        Espresso.onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                click()
            ))
        Espresso.onView(withId(R.id.iv_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_tittle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_tittle))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].title)))
        Espresso.onView(withId(R.id.tv_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_genre))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].genre)))
        Espresso.onView(withId(R.id.tvDirector))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tvDirector))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].creator)))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_story_line))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].storyLine)))
        //Convert Value of Star
        val star = dummyTvShow[0].star.toDouble().div(10)
        Espresso.onView(withId(R.id.tv_star))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_star))
            .check(ViewAssertions.matches(withText(star.toString())))

    }

}