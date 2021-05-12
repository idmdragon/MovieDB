package com.idm.moviedb.ui.movies.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.databinding.HorizontalItemBinding
import com.idm.moviedb.databinding.VerticalItemBinding

class MoviePagedListAdapterHorizontal:PagedListAdapter<MovieTopRated, MoviesListHorizontalViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieTopRated> = object : DiffUtil.ItemCallback<MovieTopRated>() {
            override fun areItemsTheSame(oldList: MovieTopRated, newList: MovieTopRated): Boolean {
                return oldList.title == newList.title && oldList.id == newList.id
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: MovieTopRated, newList: MovieTopRated): Boolean {
                return oldList == newList
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListHorizontalViewHolder {
        val itemBinding =
            HorizontalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListHorizontalViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MoviesListHorizontalViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieTopRated)
    }



}