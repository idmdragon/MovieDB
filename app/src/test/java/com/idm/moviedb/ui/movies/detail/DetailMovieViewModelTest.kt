package com.idm.moviedb.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.TestCoroutineRule
import com.idm.moviedb.data.models.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.utils.DummyMovie
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var detailMovieObserver: Observer<MovieDetailResponse>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(mainRepository)

    }


    @Test
    fun getDetailMovie() = testCoroutineRule.runBlockingTest {
        val dummyMovies = DummyMovie.generateTopMovieDetail()
        val detailMovie = MutableLiveData(dummyMovies)
        `when`(mainRepository.getDetailMovie(19404)).thenReturn(detailMovie)
        val movieEntities = viewModel.getDetailMovie(19404).value
        verify(mainRepository).getDetailMovie(19404)
        assertNotNull(movieEntities)

        viewModel.getDetailMovie(19404).observeForever(detailMovieObserver)
        viewModel.getDetailMovie(19404).removeObserver(detailMovieObserver)
    }


}