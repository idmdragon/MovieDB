package com.idm.moviedb.ui.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.TestCoroutineRule
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.data.models.search.SearchResult
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.ui.movies.home.MoviesViewModel
import com.idm.moviedb.utils.DummyMovie
import com.idm.moviedb.utils.DummySearch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var listMovieObserver: Observer<ArrayList<SearchResult>>

    @Before
    fun setUp() {
        viewModel = SearchViewModel(mainRepository)
    }


    @Test
    fun getTopRated() = testCoroutineRule.runBlockingTest {
        val _listMovie = MutableLiveData(DummySearch.getDummySearch())
        val listMovie : LiveData<ArrayList<SearchResult>> = _listMovie

        `when`(mainRepository.getSearchItemList()).thenReturn(listMovie)

        val movieEntities = viewModel.searchItemList.value
        verify(mainRepository).getSearchItemList()
        assertNotNull(movieEntities)

        viewModel.searchItemList.observeForever(listMovieObserver)
        viewModel.searchItemList.removeObserver(listMovieObserver)

    }



}