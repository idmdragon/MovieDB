package com.idm.moviedb.ui.tvshow.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.databinding.FavoriteItemListBinding
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.ui.search.SearchViewHolder

class TvPagedListAdapter:PagedListAdapter<TvResult, TVShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TvResult> = object : DiffUtil.ItemCallback<TvResult>() {
            override fun areItemsTheSame(oldList: TvResult, newList: TvResult): Boolean {
                return oldList.name == newList.name && oldList.id == newList.id && oldList.vote_average.toString() == newList.vote_average.toString()
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: TvResult, newList: TvResult): Boolean {
                return oldList == newList
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemBinding =
            VerticalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(getItem(position) as TvResult)
    }



}