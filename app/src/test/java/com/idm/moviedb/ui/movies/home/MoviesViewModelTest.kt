package com.idm.moviedb.ui.movies.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.source.repositories.FakeMainRepository
import com.idm.moviedb.data.source.repositories.MainRepository
import androidx.lifecycle.MutableLiveData
import net.bytebuddy.matcher.ElementMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest{

    lateinit var viewModel : MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var topMovieObserver : Observer<ArrayList<MovieResult>>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel(mainRepository)
    }

    @Test
    fun getTopRated()  {
//        lateinit var listTopRated: LiveData<ArrayList<MovieResult>>
//        lateinit var listPlayingNow: LiveData<ArrayList<MovieResult>>

        viewModel.listTopRated.observeForever(topMovieObserver)
//        verify(topMovieObserver).onChanged()
//        assertThat(6.0,`is`(6))
    }
    @Test
    fun getNowPlaying() {

    }


}