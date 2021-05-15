package com.idm.moviedb.ui.tvshow.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.utils.dummyData.DummyTv
import com.idm.moviedb.vo.Resource
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.TestCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTv = DummyTv.generateTvDetail()
    private val tvId = dummyTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var observer: Observer<Resource<TvEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(mainRepository)
        viewModel.getDetailTV(tvId)
    }

    @Test
    fun `getSelectedTv should be success`() {
        val expected = MutableLiveData<Resource<TvEntity>>()
        expected.value = Resource.success(DummyTv.generateTvDetail())
        Mockito.`when`(mainRepository.getDetailTv(tvId)).thenReturn(expected)
        viewModel.getDetailTV(tvId).observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)
        val expectedValue = expected.value
        val actualValue = viewModel.getDetailTV(tvId).value
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `setFavorite should be success `() {
        val expected = MutableLiveData<Resource<TvEntity>>()
        expected.value = Resource.success(DummyTv.generateTvDetail())
        Mockito.`when`(mainRepository.getDetailTv(tvId)).thenReturn(expected)
        val tvValue = Resource.success(viewModel.getDetailTV(tvId).value)
        viewModel.updateTv(tvValue.data?.data!!)
        Mockito.verify(mainRepository).updateTv(tvValue.data?.data!!)
        verifyNoMoreInteractions(observer)
        TestCase.assertEquals(false, tvValue.data?.data!!.favorite)
    }

}