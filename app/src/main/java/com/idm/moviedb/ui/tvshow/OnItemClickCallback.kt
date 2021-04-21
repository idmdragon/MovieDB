package com.idm.moviedb.ui.tvshow

import com.idm.moviedb.data.source.remote.tv.TvResult


interface OnItemClickCallback {
    fun onItemClicked(tvShow: TvResult)
}