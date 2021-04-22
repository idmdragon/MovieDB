package com.idm.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.data.models.movie.MovieResult
import com.idm.moviedb.databinding.HorizontalItemBinding
import com.idm.moviedb.ui.movies.home.MoviesListHorizontalViewHolder
import com.idm.moviedb.ui.movies.home.OnItemClickCallback

class ListMovieAdapter(private val listItem: ArrayList<MovieResult>) : RecyclerView.Adapter<MoviesListHorizontalViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListHorizontalViewHolder {
        val itemBinding =
            HorizontalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesListHorizontalViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holderHorizontal: MoviesListHorizontalViewHolder, position: Int) {
        holderHorizontal.bind(listItem[position])
        holderHorizontal.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holderHorizontal.adapterPosition])
        }
    }

    override fun getItemCount() = listItem.size


}