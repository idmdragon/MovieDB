package com.idm.moviedb.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.utils.dummyData.DummyMovie
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var detailMovieObserver: Observer<MovieDetailResponse>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(mainRepository)
    }

    @Test
    fun getDetailMovie(){
        val movieId = 19404
        val dummyMovie = DummyMovie.generateTopMovieDetail()
        val detailMovie = MutableLiveData(dummyMovie)
        `when`(mainRepository.getDetailMovie(movieId)).thenReturn(detailMovie)
        val movieEntities = viewModel.getDetailMovie(movieId).value
        verify(mainRepository).getDetailMovie(movieId)
        assertNotNull(movieEntities)

        if (movieEntities != null) {
            assertEquals(dummyMovie.title, movieEntities.title)
            assertEquals(dummyMovie.tagline, movieEntities.tagline)
            assertEquals(dummyMovie.release_date, movieEntities.release_date)
            assertEquals(dummyMovie.overview, movieEntities.overview)
            assertEquals(dummyMovie.genres.toString(), movieEntities.genres.toString())
            assertEquals(dummyMovie.status, movieEntities.status)
            assertEquals(dummyMovie.budget, movieEntities.budget)
            assertEquals(dummyMovie.original_title, movieEntities.original_title)
            assertEquals(dummyMovie.vote_average.toString(), movieEntities.vote_average.toString())
            assertEquals(dummyMovie.revenue.toString(), movieEntities.revenue.toString())
            assertEquals(dummyMovie.id, movieEntities.id)

        }

        viewModel.getDetailMovie(movieId).observeForever(detailMovieObserver)
        verify(detailMovieObserver).onChanged(dummyMovie)
        viewModel.getDetailMovie(movieId).removeObserver(detailMovieObserver)
    }


}