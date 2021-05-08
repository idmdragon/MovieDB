package com.idm.moviedb.ui.tvshow.home

import com.idm.moviedb.data.response.tv.TvResult


interface OnItemClickCallback {
    fun onItemClicked(tvShow: TvResult)
}