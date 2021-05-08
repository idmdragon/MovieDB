package com.idm.moviedb.ui.favorite.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.databinding.FavoriteItemListBinding

class FavoriteTvAdapter(private val listItem: List<TvDetailResponse>) : RecyclerView.Adapter<FavoriteTvViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvViewHolder {
        val itemBinding =
            FavoriteItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvViewHolder(itemBinding)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holderVertical: FavoriteTvViewHolder, position: Int) {
        holderVertical.bind(listItem[position])
        holderVertical.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listItem[holderVertical.adapterPosition])
        }
    }

    override fun getItemCount() = listItem.size


}