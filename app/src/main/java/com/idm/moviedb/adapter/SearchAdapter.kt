package com.idm.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.data.source.remote.TVShow
import com.idm.moviedb.data.source.remote.search.SearchResult
import com.idm.moviedb.databinding.ItemLayoutBinding
import com.idm.moviedb.databinding.SearchItemBinding
import com.idm.moviedb.ui.search.SearchViewHolder
import com.idm.moviedb.ui.tvshow.OnItemClickCallback
import com.idm.moviedb.ui.tvshow.TVShowViewHolder

class SearchAdapter (private val listItem: ArrayList<SearchResult>) : RecyclerView.Adapter<SearchViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val itemBinding =
            SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listItem[position])
//        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
//        }
    }

}