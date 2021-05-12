package com.idm.moviedb.ui.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.utils.dummyData.DummySearch
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
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var listMovieObserver: Observer<ArrayList<SearchResult>>

    @Before
    fun setUp() {
        viewModel = SearchViewModel(mainRepository)
    }

    @Test
    fun getTopRated() {
        val dummySearch = DummySearch.getDummySearch()
        val listMovie = MutableLiveData(dummySearch)
        val query = "Half Salmon Man"
        `when`(mainRepository.movieSearch(query)).thenReturn(listMovie)

        val movieEntities = viewModel.searchItem(query).value
        verify(mainRepository).movieSearch(query)
        assertNotNull(movieEntities)

        viewModel.searchItem(query).observeForever(listMovieObserver)
        verify(listMovieObserver).onChanged(dummySearch)
        viewModel.searchItem(query).removeObserver(listMovieObserver)

    }


}