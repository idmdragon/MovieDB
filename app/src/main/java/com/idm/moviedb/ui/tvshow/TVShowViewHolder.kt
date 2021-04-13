package com.idm.moviedb.ui.tvshow

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
import com.idm.moviedb.models.TVShow

class TVShowViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TVShow) {
        with(binding) {
            tvGenre.text = tvShow.genre
            tvTitle.text = tvShow.title
            tvHours.text = tvShow.hours

            Glide.with(itemView.context)
                .load(tvShow.poster)
                .transforms(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions().override(76, 76))
                .into(ivPoster)


        }

    }
}
