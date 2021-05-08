package com.idm.moviedb.ui.favorite.movies

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.databinding.FavoriteItemListBinding
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.utils.Constant
import java.text.SimpleDateFormat
import java.util.*

class FavoriteMovieViewHolder (private val binding: FavoriteItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieDetailResponse) {
        with(binding) {
            tvTittle.text = movie.title
            val rate: Double = movie.vote_average / 2
            ratingBar.rating = rate.toFloat()

            Glide.with(itemView.context)
                .load(Constant.IMAGE_PATH + movie.backdrop_path)
                .transform(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions())
                .into(ivPoster)


        }

    }
}