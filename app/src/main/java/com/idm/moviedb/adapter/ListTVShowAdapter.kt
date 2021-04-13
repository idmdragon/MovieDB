package com.idm.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.databinding.ItemLayoutBinding
import com.idm.moviedb.models.Movie
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.ui.movies.OnItemClickCallback
import com.idm.moviedb.ui.tvshow.TVShowViewHolder

class ListTVShowAdapter(private val listItem: ArrayList<TVShow>) : RecyclerView.Adapter<TVShowViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemBinding =
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvshow = listItem[position]
        holder.bind(tvshow)
//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
//        }
    }


}