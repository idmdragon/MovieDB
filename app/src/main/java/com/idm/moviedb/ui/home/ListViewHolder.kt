package com.idm.moviedb.ui.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.databinding.ItemLayoutBinding
import com.idm.moviedb.models.Movie

class ListViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        with(binding) {
            tvGenre.text = movie.genre
            tvTitle.text = movie.title

            Glide.with(itemView.context)
                .load(movie.poster)
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions().override(76, 76))
                .into(ivPoster)




        }

    }
}
