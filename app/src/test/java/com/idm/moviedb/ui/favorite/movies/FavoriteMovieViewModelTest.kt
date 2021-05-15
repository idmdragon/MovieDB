package com.idm.moviedb.ui.favorite.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.MovieEntity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: FavoriteMovieViewModel

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>


    @Before
    fun setup() {
        viewModel = FavoriteMovieViewModel(mainRepository)
    }

    @Test
    fun getListFavoriteMovie() {
        val moviePaged = moviePagedList
        `when`(moviePaged.size).thenReturn(5)
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = moviePaged
        `when`(mainRepository.getAllFavoriteMovie()).thenReturn(expected)
        val movieEntity = viewModel.getAllFavoriteMovie().value
        verify(mainRepository).getAllFavoriteMovie()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)
        viewModel.getAllFavoriteMovie().observeForever(observerMovie)
       verify(observerMovie).onChanged(moviePaged)
    }

}