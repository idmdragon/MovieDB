package com.idm.moviedb.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.databinding.VerticalItemBinding

class SearchPagedListAdapter:PagedListAdapter<SearchResult, SearchViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<SearchResult> = object : DiffUtil.ItemCallback<SearchResult>() {
            override fun areItemsTheSame(oldList: SearchResult, newList: SearchResult): Boolean {
                return oldList.title == newList.title && oldList.id == newList.id && oldList.vote_average.toString() == newList.vote_average.toString()
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldList: SearchResult, newList: SearchResult): Boolean {
                return oldList == newList
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val itemBinding =
            VerticalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position) as SearchResult)
    }

}