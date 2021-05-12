package com.idm.moviedb.ui.movies.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.databinding.FavoriteItemListBinding
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.ui.search.SearchViewHolder

class MoviePagedListAdapterVertical:PagedListAdapter<MovieResult, MoviesListVerticalViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieResult> = object : DiffUtil.ItemCallback<MovieResult>() {
            override fun areItemsTheSame(oldList: MovieResult, newList: MovieResult): Boolean {
                return oldList.title == newList.title && oldList.id == newList.id && oldList.vote_average.toString() == newList.vote_average.toString()
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: MovieResult, newList: MovieResult): Boolean {
                return oldList == newList
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListVerticalViewHolder {
        val itemBinding =
            VerticalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListVerticalViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MoviesListVerticalViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieResult)
    }



}