package com.idm.moviedb.ui.movies.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.source.repositories.MainRepository
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.TestCoroutineRule
import com.idm.moviedb.utils.DummyMovie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var listMovieObserver: Observer<ArrayList<MovieResult>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(mainRepository)
    }


    @Test
    fun getTopRated() = testCoroutineRule.runBlockingTest {
        val dummyMovies = DummyMovie.generateTopMovie()
        val listMovie = MutableLiveData(dummyMovies)
        `when`(mainRepository.getTopRated()).thenReturn(listMovie)
        val movieEntities = viewModel.getTopValue().value
        verify(mainRepository).getTopRated()
        assertNotNull(movieEntities)

        viewModel.getTopValue().observeForever(listMovieObserver)
        viewModel.getTopValue().removeObserver(listMovieObserver)

    }

    @Test
    fun getNowPlaying() = testCoroutineRule.runBlockingTest {
        val dummyMovies = DummyMovie.generateNowPlaying()
        val listMovie = MutableLiveData(dummyMovies)
        `when`(mainRepository.getNowPlaying()).thenReturn(listMovie)
        val movieEntities = viewModel.getNowPlayingValue().value
        verify(mainRepository).getNowPlaying()
        assertNotNull(movieEntities)

        viewModel.getNowPlayingValue().observeForever(listMovieObserver)
        viewModel.getNowPlayingValue().removeObserver(listMovieObserver)
    }


}