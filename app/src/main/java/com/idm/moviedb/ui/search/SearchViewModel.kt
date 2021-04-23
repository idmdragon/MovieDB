package com.idm.moviedb.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.repositories.MainRepository
import com.idm.moviedb.data.models.search.SearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {


    val searchItemList: LiveData<ArrayList<SearchResult>> = repository.getSearchItemList()

    fun searchItem(query : String) = viewModelScope.launch {
        repository.movieSearch(query)
    }


}