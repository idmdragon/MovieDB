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
import com.idm.moviedb.data.source.remote.movie.detail.MovieDetailResponse
import com.idm.moviedb.utils.Constant
import java.text.NumberFormat
import java.util.*


class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val MOVIE_ID = "movie_id"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieID = intent.getIntExtra(MOVIE_ID,0)

        detailMovieViewModel.setDetail(movieID)

        binding.btnBack.setOnClickListener {
            finish()
        }

        detailMovieViewModel.detailMovie.observe(this,::bindData)

    }

    private fun bindData(movie: MovieDetailResponse) {
        with(binding) {
            tvTittle.text = movie.title
            val taglineNotFound = "Tagline Not Found"
            val tagline = if (movie.tagline!=""){
                movie.tagline
            }else{
                taglineNotFound
            }
            tvTagline.text = tagline
            tvStatus.text = movie.status

             val listGenre  = movie.genres.map {
                 it.name
             }

            tvGenre.text = listGenre.joinToString()
            tvStoryLine.text = movie.overview

            val budget = movie.budget
            val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
            tvBudget.text = convertBudget

            val revenue = movie.revenue
            val convertRevenue = NumberFormat.getNumberInstance(Locale.US).format(revenue)
            tvRevenue.text = convertRevenue

            val star = movie.vote_average
            tvStar.text = star.toString()
            Glide.with(this@DetailMovieActivity)
                .load(Constant.IMAGE_PATH +movie.poster_path)
                .transform(CenterCrop(), RoundedCorners(16))
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)


        }
    }
}