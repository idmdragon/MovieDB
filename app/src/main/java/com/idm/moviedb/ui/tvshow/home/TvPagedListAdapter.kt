package com.idm.moviedb.ui.tvshow.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.databinding.VerticalItemBinding

class TvPagedListAdapter:PagedListAdapter<TvEntity, TVShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TvEntity> = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldList: TvEntity, newList: TvEntity): Boolean {
                return oldList.name == newList.name
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: TvEntity, newList: TvEntity): Boolean {
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
        holder.bind(getItem(position) as TvEntity)
    }



}