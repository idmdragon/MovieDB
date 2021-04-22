package com.idm.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.ui.movies.home.MoviesListVerticalViewHolder
import com.idm.moviedb.ui.movies.home.OnItemClickCallback

class ListVerticalMovieAdapter(private val listItem: ArrayList<MovieResult>) : RecyclerView.Adapter<MoviesListVerticalViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListVerticalViewHolder {
        val itemBinding =
            VerticalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListVerticalViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holderVertical: MoviesListVerticalViewHolder, position: Int) {
        holderVertical.bind(listItem[position])
        holderVertical.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holderVertical.adapterPosition])
        }
    }

    override fun getItemCount() = listItem.size


}