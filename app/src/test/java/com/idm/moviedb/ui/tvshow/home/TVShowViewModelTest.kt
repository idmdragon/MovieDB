package com.idm.moviedb.ui.tvshow.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.TestCoroutineRule
import com.idm.moviedb.data.models.tv.TvResult
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.utils.DummyTv
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
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var listTvObserver: Observer<ArrayList<TvResult>>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(mainRepository)
    }


    @Test
    fun getListTvShow() = testCoroutineRule.runBlockingTest {
        val dummyTv = DummyTv.generateListTvShow()
        val listTv = MutableLiveData(dummyTv)
        `when`(mainRepository.getTvPopular()).thenReturn(listTv)
        val movieEntities = viewModel.getTvValueTvPopular().value
        verify(mainRepository).getTvPopular()
        assertNotNull(movieEntities)

        viewModel.getTvValueTvPopular().observeForever(listTvObserver)
        viewModel.getTvValueTvPopular().removeObserver(listTvObserver)

    }
}