package com.idm.moviedb.ui.detail.movie

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.idm.moviedb.databinding.ActivityDetailMovieBinding
import com.idm.moviedb.models.Movie
import java.text.NumberFormat
import java.util.*


class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val MOVIE_TITLE = "movie_title"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(MOVIE_TITLE)

        if (title != null) {
            detailMovieViewModel.setItem(title)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
        detailMovieViewModel._itemMovie.observe(this, ::bindData)

    }

    private fun bindData(movie: Movie?) {
        with(binding) {
            if (movie != null) {
                tvTittle.text = movie.title
                tvDirector.text = movie.directors
                tvGenre.text = movie.genre
                tvStoryLine.text = movie.storyLine

                val budget = movie.budget
                val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
                tvBudget.text = convertBudget

                val star = movie.star.toDouble().div(10)
                tvStar.text = star.toString()
                Glide.with(this@DetailMovieActivity)
                    .load(movie.poster)
                    .transform(CenterCrop(), RoundedCorners(16))
                    .placeholder(ColorDrawable(Color.GRAY))
                    .into(ivPoster)


            }
        }
    }
}