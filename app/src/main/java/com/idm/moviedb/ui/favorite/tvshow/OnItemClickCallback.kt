package com.idm.moviedb.ui.favorite.tvshow

import com.idm.moviedb.data.response.tv.detail.TvDetailResponse


interface OnItemClickCallback {
    fun onItemClicked(tvShow: TvDetailResponse)
}