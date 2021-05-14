package com.idm.moviedb.ui.movies.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.databinding.VerticalItemBinding

class MoviePagedListAdapter:PagedListAdapter<MovieEntity, MoviesListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieEntity> = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldList: MovieEntity, newList: MovieEntity): Boolean {
                return oldList.title == newList.title
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: MovieEntity, newList: MovieEntity): Boolean {
                return oldList == newList
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val itemBinding =
            VerticalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieEntity)
    }



}