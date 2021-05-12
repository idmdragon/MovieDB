package com.idm.moviedb.ui.movies.home

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.databinding.HorizontalItemBinding
import com.idm.moviedb.ui.movies.detail.DetailMovieActivity
import com.idm.moviedb.utils.Constant.Companion.IMAGE_PATH

class MoviesListHorizontalViewHolder(private val binding: HorizontalItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieTopRated) {
        with(binding) {
            tvTitle.text = movie.title

            Glide.with(itemView.context)
                .load(IMAGE_PATH+movie.backdrop_path)
                .transform(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions())
                .into(ivPoster)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.MOVIE_ID, movie.id)
                itemView.context.startActivity(intent)
            }

        }

    }
}
