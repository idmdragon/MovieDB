package com.idm.moviedb.ui.movies.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.vo.Resource
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>


    @Before
    fun setUp() {
        viewModel = MoviesViewModel(mainRepository)
    }

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>


    @Test
    fun `getMovie should be success`() {
        val movie = Resource.success(pagedList)
        `when`(movie.data?.size).thenReturn(10)
        val expected = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        expected.value = movie
        `when`(mainRepository.getMovieList()).thenReturn(expected)
        val movieEntities = viewModel.getNowPlaying().value?.data
        Mockito.verify(mainRepository).getMovieList()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(10, movieEntities?.size)
        viewModel.getNowPlaying().observeForever(observer)
        Mockito.verify(observer).onChanged(movie)
    }



}