package com.idm.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.databinding.ItemLayoutBinding
import com.idm.moviedb.models.Movie
import com.idm.moviedb.ui.movies.MoviesListViewHolder
import com.idm.moviedb.ui.movies.OnItemClickCallback

class ListMovieAdapter(private val listItem: ArrayList<Movie>) : RecyclerView.Adapter<MoviesListViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val itemBinding =
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        val movie = listItem[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }

    override fun getItemCount() = listItem.size


}