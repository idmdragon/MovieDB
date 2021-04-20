package com.idm.moviedb.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idm.moviedb.data.source.remote.RetrofitInstance
import com.idm.moviedb.data.source.remote.search.SearchResponse
import com.idm.moviedb.data.source.remote.search.SearchResult
import com.idm.moviedb.utils.Constant.Companion.API_KEY
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _searchItemList = MutableLiveData<ArrayList<SearchResult>>()
    val searchItemList : LiveData<ArrayList<SearchResult>> = _searchItemList

    private val _itemCount = MutableLiveData<Int>()
    val itemCount : LiveData<Int> = _itemCount

    fun searchItem(query : String) = viewModelScope.launch {
       RetrofitInstance.api.multiSearch(API_KEY,query).let {
           _searchItemList.postValue(it.body()?.results)
           _itemCount.postValue(it.body()?.total_results)
       }



    }
}