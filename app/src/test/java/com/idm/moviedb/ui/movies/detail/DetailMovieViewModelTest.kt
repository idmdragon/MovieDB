package com.idm.moviedb.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.utils.dummyData.DummyMovie
import com.idm.moviedb.vo.Resource
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.TestCase
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
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DummyMovie.generateNowPlayingMovie()
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(mainRepository)
        viewModel.getDetailMovie(movieId)
    }

    @Test
    fun `getSelectedMovie should be success`() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(DummyMovie.generateNowPlayingMovie())
        `when`(mainRepository.getDetailMovie(movieId)).thenReturn(expected)
        viewModel.getDetailMovie(movieId).observeForever(observer)
        verify(observer).onChanged(expected.value)
        val expectedValue = expected.value
        val actualValue = viewModel.getDetailMovie(movieId).value
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFavorite should be success `() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(DummyMovie.generateNowPlayingMovie())
        `when`(mainRepository.getDetailMovie(movieId)).thenReturn(expected)
        val movievalue = Resource.success(viewModel.getDetailMovie(movieId).value)
        viewModel.updateMovie(movievalue.data?.data!!)
        verify(mainRepository).updateMovie(movievalue.data?.data!!)
        verifyNoMoreInteractions(observer)
        TestCase.assertEquals(false, movievalue.data?.data!!.favorite)
    }
}