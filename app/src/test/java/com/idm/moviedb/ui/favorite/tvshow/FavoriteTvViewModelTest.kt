package com.idm.moviedb.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.TvEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: FavoriteTvViewModel

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<TvEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<TvEntity>


    @Before
    fun setup() {
        viewModel = FavoriteTvViewModel(mainRepository)
    }

    @Test
    fun getListFavoriteTv() {
        val moviePaged = moviePagedList
        Mockito.`when`(moviePaged.size).thenReturn(5)
        val expected = MutableLiveData<PagedList<TvEntity>>()
        expected.value = moviePaged
        Mockito.`when`(mainRepository.getAllFavoriteTv()).thenReturn(expected)
        val tvEntity = viewModel.getAllTvMovie().value
        Mockito.verify(mainRepository).getAllFavoriteTv()
        assertNotNull(tvEntity)
        assertEquals(5, tvEntity?.size)
        viewModel.getAllTvMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(moviePaged)
    }

}