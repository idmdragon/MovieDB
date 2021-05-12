package com.idm.moviedb.ui.tvshow.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.utils.dummyData.DummyTv
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
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var detailTvObserver: Observer<TvDetailResponse>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(mainRepository)

    }

    @Test
    fun getDetailTv() {
        val dummyTv = DummyTv.generateTvDetail()
        val detailTv = MutableLiveData(dummyTv)
        val tvId = 88396
        `when`(mainRepository.getDetailTv(tvId)).thenReturn(detailTv)
        val tvEntities = viewModel.getDetailTV(tvId).value
        verify(mainRepository).getDetailTv(tvId)
        assertNotNull(tvEntities)

        if (tvEntities != null) {
            assertEquals(dummyTv.name, tvEntities.name)
            assertEquals(dummyTv.tagline, tvEntities.tagline)
            assertEquals(dummyTv.number_of_episodes, tvEntities.number_of_episodes)
            assertEquals(dummyTv.overview, tvEntities.overview)
            assertEquals(dummyTv.genres.toString(), tvEntities.genres.toString())
            assertEquals(dummyTv.status, tvEntities.status)
            assertEquals(dummyTv.poster_path, tvEntities.poster_path)
            assertEquals(
                dummyTv.vote_average.toString(),
                tvEntities.vote_average.toString()
            )
           assertEquals(dummyTv.backdrop_path, tvEntities.backdrop_path)

        }
        viewModel.getDetailTV(tvId).observeForever(detailTvObserver)
        verify(detailTvObserver).onChanged(dummyTv)
        viewModel.getDetailTV(tvId).removeObserver(detailTvObserver)
    }


}