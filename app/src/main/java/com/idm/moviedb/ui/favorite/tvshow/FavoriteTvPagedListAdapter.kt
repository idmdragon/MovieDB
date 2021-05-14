package com.idm.moviedb.ui.favorite.tvshow

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.databinding.FavoriteItemListBinding

class FavoriteTvPagedListAdapter:PagedListAdapter<TvEntity, FavoriteTvViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TvEntity> = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldList: TvEntity, newList: TvEntity): Boolean {
                return oldList.name == newList.name && oldList.id == newList.id && oldList.vote_average.toString() == newList.vote_average.toString()
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: TvEntity, newList: TvEntity): Boolean {
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
        holder.bind(getItem(position) as TvEntity)
    }

}