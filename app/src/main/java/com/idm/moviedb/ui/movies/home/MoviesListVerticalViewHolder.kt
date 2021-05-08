package com.idm.moviedb.ui.movies.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.utils.Constant.Companion.IMAGE_PATH
import java.text.SimpleDateFormat
import java.util.*

class MoviesListVerticalViewHolder(private val binding: VerticalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieResult) {
        with(binding) {
            tvTittle.text = movie.title

            val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(movie.release_date)
            if (date != null) {
                val formattedDatesString = SimpleDateFormat("MMM dd, yyyy", Locale.US).format(date)
                tvDate.text = formattedDatesString
            }

            val rate: Double = movie.vote_average / 2

            ratingBar.rating = rate.toFloat()

            Glide.with(itemView.context)
                .load(IMAGE_PATH + movie.backdrop_path)
                .transform(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions())
                .into(ivPoster)


        }

    }
}
