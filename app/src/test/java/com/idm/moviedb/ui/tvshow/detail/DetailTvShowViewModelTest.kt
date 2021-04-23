package com.idm.moviedb.ui.tvshow.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.TestCoroutineRule
import com.idm.moviedb.data.models.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.utils.DummyTv
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var detailTvObserver: Observer<TvDetailResponse>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(mainRepository)

    }


    @Test
    fun getDetailTv() = testCoroutineRule.runBlockingTest {
        val dummyTv = DummyTv.generateTvDetail()
        val detailTv = MutableLiveData(dummyTv)
        `when`(mainRepository.getDetailTv(88396)).thenReturn(detailTv)
        val tvEntities = viewModel.getDetail(88396).value
        verify(mainRepository).getDetailTv(88396)
        assertNotNull(tvEntities)

        viewModel.getDetail(88396).observeForever(detailTvObserver)
        viewModel.getDetail(88396).removeObserver(detailTvObserver)
    }


}