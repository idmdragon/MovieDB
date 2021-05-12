package com.idm.moviedb.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.idm.moviedb.data.repositories.MainRepository
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    fun searchItem(query : String) = repository.movieSearch(query)

}