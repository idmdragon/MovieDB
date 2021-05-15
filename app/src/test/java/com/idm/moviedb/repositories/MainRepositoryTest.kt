package com.idm.moviedb.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.idm.moviedb.data.source.local.LocalDataSource
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.data.source.remote.RemoteDataSource
import com.idm.moviedb.utils.AppExecutors
import com.idm.moviedb.utils.LiveDataTestUtil
import com.idm.moviedb.utils.PagedListUtil
import com.idm.moviedb.utils.TestExecutor
import com.idm.moviedb.utils.dummyData.DummyMovie
import com.idm.moviedb.utils.dummyData.DummyTv
import com.idm.moviedb.vo.Resource.Companion.success
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*


class MainRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)
    private val testExecutor = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())


    @Mock
    private val mainRepository = FakeMainRepository(remote,local,appExecutor)
    private val listMovie = DummyMovie.generateNowPlaying()
    private val itemMovie = DummyMovie.generateNowPlayingMovie()

    private val listTv = DummyTv.generateListTvShow()
    private val itemTv = DummyTv.generateTvDetail()
    private val tvId = itemTv.id


    @Test
    fun getMovieList() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovieList()).thenReturn(dataSource)
        mainRepository.getMovieList()

        val movie = success(PagedListUtil.mockPagedList(DummyMovie.generateNowPlaying()))
        verify(local).getMovieList()
        Assert.assertNotNull(movie.data)
        assertEquals(listMovie.size.toLong(), movie.data?.size?.toLong())
    }


    @Test
    fun getTvPopular() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getTvList()).thenReturn(dataSource)
        mainRepository.getTvPopular()

        val tv = success(PagedListUtil.mockPagedList(DummyTv.generateListTvShow()))
        verify(local).getTvList()
        Assert.assertNotNull(tv.data)
        assertEquals(listTv.size.toLong(), tv.data?.size?.toLong())

    }
    @Test
    fun getDetailMovie() {
    val expected = MutableLiveData<MovieEntity>()
        expected.value = itemMovie
        `when`(local.getDetailMovie(itemMovie.id)).thenReturn(expected)

        val movieEntities = LiveDataTestUtil.getValue(mainRepository.getDetailMovie(itemMovie.id))
        verify(local).getDetailMovie(itemMovie.id)
        assertNotNull(movieEntities.data)
        assertEquals(itemMovie.id,movieEntities.data?.id)
    }
    @Test
    fun getDetailTv() {
        val expected = MutableLiveData<TvEntity>()
        expected.value = itemTv
        `when`(local.getDetailTv(itemTv.id)).thenReturn(expected)

        val tvEntities = LiveDataTestUtil.getValue(mainRepository.getDetailTv(itemTv.id))
        verify(local).getDetailTv(itemTv.id)
        assertNotNull(tvEntities.data)
        assertEquals(itemTv.id,tvEntities.data?.id)

    }
    @Test
    fun updateMovie(){
        `when`(appExecutor.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).updateMovie(itemMovie)
        mainRepository.updateMovie(itemMovie)
        verify(local, times(1)).updateMovie(itemMovie)
        TestCase.assertEquals(false, itemMovie.favorite)
    }

    @Test
    fun updateTv(){
        `when`(appExecutor.diskIO()).thenReturn(testExecutor.diskIO())
        doNothing().`when`(local).updateTv(itemTv)
        mainRepository.updateTv(itemTv)
        verify(local, times(1)).updateTv(itemTv)
        TestCase.assertEquals(false, itemTv.favorite)
    }

    @Test
    fun getAllFavoriteMovie() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllFavoriteMovieItems()).thenReturn(dataSource)
        mainRepository.getAllFavoriteMovie()

        val moviesEntity = success(PagedListUtil.mockPagedList(DummyMovie.generateNowPlaying()))
        verify(local).getAllFavoriteMovieItems()
        Assert.assertNotNull(moviesEntity.data)
        assertEquals(listMovie.size.toLong(), moviesEntity.data?.size?.toLong())

    }

    @Test
    fun getAllFavoriteTv() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getAllFavoriteTVItems()).thenReturn(dataSource)
        mainRepository.getAllFavoriteTv()

        val tvEntities = success(PagedListUtil.mockPagedList(DummyTv.generateListTvShow()))
        verify(local).getAllFavoriteTVItems()
        Assert.assertNotNull(tvEntities.data)
        assertEquals(listTv.size.toLong(), tvEntities.data?.size?.toLong())

    }
}