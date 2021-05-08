package com.idm.moviedb.ui.search

import androidx.lifecycle.ViewModel
import com.idm.moviedb.data.source.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    fun searchItem(query : String) = repository.movieSearch(query)



}