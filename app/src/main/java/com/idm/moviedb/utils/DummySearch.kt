package com.idm.moviedb.utils

import com.idm.moviedb.data.response.search.SearchResult

object DummySearch {
    fun getDummySearch(): ArrayList<SearchResult> {
        val listSearch = ArrayList<SearchResult>()
        listSearch.add(
            SearchResult(
                backdrop_path = "",
                id = 219048,
                poster_path = "/3V8xJIFe1GTEcB3omF4lYlPQJji.jpg",
                release_date = "2013-10-09",
                title = "Half Salmon Man",
                vote_average = 6.4
            )
        )
        return listSearch
    }
}