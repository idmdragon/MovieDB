package com.idm.moviedb.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.MainRepository
import com.idm.moviedb.data.source.remote.search.SearchResult
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor (
        val repository: MainRepository
        ): ViewModel() {

    private val _searchItemList = MutableLiveData<ArrayList<SearchResult>>()
    val searchItemList : LiveData<ArrayList<SearchResult>> = _searchItemList


    fun searchItem(query : String) = viewModelScope.launch {
        repository.movieSearch(query).let { response ->
               _searchItemList.postValue(response.body()?.results)
       }



    }
}