package com.idm.moviedb.ui.tvshow.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.utils.dummyData.DummyTv
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
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var listTvObserver: Observer<ArrayList<TvResult>>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(mainRepository)
    }


    @Test
    fun getListTvShow() {
        val dummyTv = DummyTv.generateListTvShow()
        val listTv = MutableLiveData(dummyTv)
        `when`(mainRepository.getTvPopular()).thenReturn(listTv)
        val movieEntities = viewModel.getTvPopular().value
        verify(mainRepository).getTvPopular()
        assertNotNull(movieEntities)

        viewModel.getTvPopular().observeForever(listTvObserver)
        verify(listTvObserver).onChanged(dummyTv)
        viewModel.getTvPopular().removeObserver(listTvObserver)

    }
}