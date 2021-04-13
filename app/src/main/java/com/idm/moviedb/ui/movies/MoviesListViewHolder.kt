package com.idm.moviedb.ui.movies

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.databinding.ItemLayoutBinding
import com.idm.moviedb.models.Movie

class MoviesListViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        with(binding) {
            tvGenre.text = movie.genre
            tvTitle.text = movie.title
            tvHours.text = movie.hours

            Glide.with(itemView.context)
                .load(movie.poster)
                .transforms(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions().override(76, 76))
                .into(ivPoster)


        }

    }
}
