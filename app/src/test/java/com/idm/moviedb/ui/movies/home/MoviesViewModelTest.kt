package com.idm.moviedb.ui.movies.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.idm.moviedb.data.response.movie.MovieResult
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.utils.dummyData.DummyMovie
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var listMovieObserver: Observer<ArrayList<MovieResult>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(mainRepository)
    }


    @Test
    fun getTopRated() {
        val dummyMovie = DummyMovie.generateTopMovie()
        val listMovie = MutableLiveData(dummyMovie)
        `when`(mainRepository.getTopRated()).thenReturn(listMovie)
        val movieEntities = viewModel.getTopRated().value
        verify(mainRepository).getTopRated()
        assertNotNull(movieEntities)
        viewModel.getTopRated().observeForever(listMovieObserver)
        verify(listMovieObserver).onChanged(dummyMovie)
        viewModel.getTopRated().removeObserver(listMovieObserver)

    }

    @Test
    fun getNowPlaying() {
        val dummyMovies = DummyMovie.generateNowPlaying()
        val listMovie = MutableLiveData(dummyMovies)
        `when`(mainRepository.getNowPlaying()).thenReturn(listMovie)
        val movieEntities = viewModel.getNowPlaying().value
        verify(mainRepository).getNowPlaying()
        assertNotNull(movieEntities)
        viewModel.getNowPlaying().observeForever(listMovieObserver)
        verify(listMovieObserver).onChanged(dummyMovies)
        viewModel.getNowPlaying().removeObserver(listMovieObserver)
    }


}