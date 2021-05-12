package com.idm.moviedb.ui.favorite.tvshow

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.databinding.FavoriteItemListBinding

class FavoriteTvPagedListAdapter:PagedListAdapter<TvDetailResponse, FavoriteTvViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TvDetailResponse> = object : DiffUtil.ItemCallback<TvDetailResponse>() {
            override fun areItemsTheSame(oldList: TvDetailResponse, newList: TvDetailResponse): Boolean {
                return oldList.name == newList.name && oldList.id == newList.id && oldList.vote_average.toString() == newList.vote_average.toString()
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: TvDetailResponse, newList: TvDetailResponse): Boolean {
                return oldList == newList
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvViewHolder {
        val itemBinding =
            FavoriteItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvViewHolder, position: Int) {
        holder.bind(getItem(position) as TvDetailResponse)
    }

}