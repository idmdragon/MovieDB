package com.idm.moviedb.ui.favorite.movies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.databinding.FavoriteItemListBinding

class FavoriteMoviePagedListAdapter:PagedListAdapter<MovieDetailResponse, FavoriteMovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieDetailResponse> = object : DiffUtil.ItemCallback<MovieDetailResponse>() {
            override fun areItemsTheSame(oldList: MovieDetailResponse, newList: MovieDetailResponse): Boolean {
                return oldList.title == newList.title && oldList.id == newList.id && oldList.vote_average.toString() == newList.vote_average.toString()
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: MovieDetailResponse, newList: MovieDetailResponse): Boolean {
                return oldList == newList
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemBinding =
            FavoriteItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieDetailResponse)
    }

}