package com.idm.moviedb.ui.favorite.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.databinding.FavoriteItemListBinding

class FavoriteMovieAdapter(private val listItem: List<MovieDetailResponse>) : RecyclerView.Adapter<FavoriteMovieViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val itemBinding =
            FavoriteItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holderVertical: FavoriteMovieViewHolder, position: Int) {
        holderVertical.bind(listItem[position])
        holderVertical.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holderVertical.adapterPosition])
        }
    }

    override fun getItemCount() = listItem.size


}