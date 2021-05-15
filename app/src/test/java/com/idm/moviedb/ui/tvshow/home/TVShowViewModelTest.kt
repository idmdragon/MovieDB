package com.idm.moviedb.ui.tvshow.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.vo.Resource
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var pagedList: PagedList<TvEntity>


    @Before
    fun setUp() {
        viewModel = TVShowViewModel(mainRepository)
    }

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvEntity>>>


    @Test
    fun `getTv should be success`() {
        val tv = Resource.success(pagedList)
        Mockito.`when`(tv.data?.size).thenReturn(10)
        val expected = MutableLiveData<Resource<PagedList<TvEntity>>>()
        expected.value = tv
        Mockito.`when`(mainRepository.getTvPopular()).thenReturn(expected)
        val movieEntities = viewModel.getTvPopular().value?.data
        Mockito.verify(mainRepository).getTvPopular()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(10, movieEntities?.size)
        viewModel.getTvPopular().observeForever(observer)
        Mockito.verify(observer).onChanged(tv)
    }
}