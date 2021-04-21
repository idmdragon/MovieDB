package com.idm.moviedb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.data.source.remote.tv.TvResult
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.ui.tvshow.OnItemClickCallback
import com.idm.moviedb.ui.tvshow.TVShowViewHolder

class ListTVShowAdapter(private val listItem: ArrayList<TvResult>) : RecyclerView.Adapter<TVShowViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemBinding =
            VerticalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(listItem[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holder.adapterPosition])
        }
    }

}