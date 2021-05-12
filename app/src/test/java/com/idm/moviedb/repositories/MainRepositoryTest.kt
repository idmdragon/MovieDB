package com.idm.moviedb.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.source.remote.ApiService
import com.idm.moviedb.data.source.repositories.FakeMainRepository
import com.idm.moviedb.utils.dummyData.DummyMovie
import com.idm.moviedb.utils.dummyData.DummySearch
import com.idm.moviedb.utils.dummyData.DummyTv
import com.idm.moviedb.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(ApiService::class.java)

    @Mock
    private val repository = FakeMainRepository(remote)
    private val movieResponses = DummyMovie.generateTopMovie()
    private val movieDetailResponse = DummyMovie.generateTopMovieDetail()
    private val nowPlayingResponse = DummyMovie.generateNowPlaying()
    private val tvShowResponses = DummyTv.generateListTvShow()
    private val tvDetailResponse = DummyTv.generateTvDetail()
    private val searchResponse = DummySearch.getDummySearch()

    @Test
    fun getTopMovies() {
        val listMovie = MutableLiveData(movieResponses)
        `when`(repository.getTopRated()).thenReturn(listMovie)
        val moviesEntites = LiveDataTestUtil.getValue(repository.getTopRated())
        verify(repository).getTopRated()
        assertNotNull(moviesEntites)
        assertEquals(movieResponses.size,moviesEntites.size)
    }

    @Test
    fun getNowPlaying(){
        val listMovie = MutableLiveData(nowPlayingResponse)
        `when`(repository.getNowPlaying()).thenReturn(listMovie)
        val moviesEntites = LiveDataTestUtil.getValue(repository.getNowPlaying())
        verify(repository).getNowPlaying()
        assertNotNull(moviesEntites)
        assertEquals(nowPlayingResponse.size,moviesEntites.size)
    }

    @Test
    fun movieSearch(){
        val query = "Half Salmon Man"
        val listMovie = MutableLiveData(searchResponse)
        `when`(repository.movieSearch(query)).thenReturn(listMovie)
        val moviesEntites = LiveDataTestUtil.getValue(repository.movieSearch(query))
        verify(repository).movieSearch(query)
        assertNotNull(moviesEntites)
        assertEquals(searchResponse.size,moviesEntites.size)
    }
    @Test
    fun getTvPopular(){
        val listTv = MutableLiveData(tvShowResponses)
        `when`(repository.getTvPopular()).thenReturn(listTv)
        val moviesEntites = LiveDataTestUtil.getValue(repository.getTvPopular())
        verify(repository).getTvPopular()
        assertNotNull(moviesEntites)
        assertEquals(tvShowResponses.size,moviesEntites.size)
    }
    @Test
    fun getDetailMovie(){
        val movieId = 19404
        val movieDetail = MutableLiveData(movieDetailResponse)
        `when`(repository.getDetailMovie(movieId)).thenReturn(movieDetail)
        val movieEntities = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))
        verify(repository).getDetailMovie(movieId)
        assertNotNull(movieEntities)
        assertEquals(movieDetailResponse,movieEntities)
        assertEquals(movieDetailResponse.title, movieEntities.title)
        assertEquals(movieDetailResponse.tagline, movieEntities.tagline)
        assertEquals(movieDetailResponse.release_date, movieEntities.release_date)
        assertEquals(movieDetailResponse.overview, movieEntities.overview)
        assertEquals(movieDetailResponse.genres.toString(), movieEntities.genres.toString())
        assertEquals(movieDetailResponse.status, movieEntities.status)
        assertEquals(movieDetailResponse.budget, movieEntities.budget)
        assertEquals(movieDetailResponse.original_title, movieEntities.original_title)
        assertEquals(
            movieDetailResponse.vote_average.toString(),
            movieEntities.vote_average.toString()
        )
        assertEquals(movieDetailResponse.revenue.toString(), movieEntities.revenue.toString())
        assertEquals(movieDetailResponse.id, movieEntities.id)
    }
    @Test
    fun getDetailTv(){
        val tvId = 19404
        val tvDetail = MutableLiveData(tvDetailResponse)
        `when`(repository.getDetailTv(tvId)).thenReturn(tvDetail)
        val tvEntities = LiveDataTestUtil.getValue(repository.getDetailTv(tvId))
        verify(repository).getDetailTv(tvId)
        assertNotNull(tvEntities)

        assertEquals(tvDetailResponse.name, tvEntities.name)
        assertEquals(tvDetailResponse.tagline, tvEntities.tagline)
        assertEquals(tvDetailResponse.number_of_episodes, tvEntities.number_of_episodes)
        assertEquals(tvDetailResponse.overview, tvEntities.overview)
        assertEquals(tvDetailResponse.genres.toString(), tvEntities.genres.toString())
        assertEquals(tvDetailResponse.status, tvEntities.status)
        assertEquals(tvDetailResponse.poster_path, tvEntities.poster_path)
        assertEquals(
            tvDetailResponse.vote_average.toString(),
            tvEntities.vote_average.toString()
        )
        assertEquals(tvDetailResponse.backdrop_path, tvEntities.backdrop_path)
    }


}