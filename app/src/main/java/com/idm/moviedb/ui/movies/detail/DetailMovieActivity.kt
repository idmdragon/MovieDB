package com.idm.moviedb.ui.movies.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.snackbar.Snackbar
import com.idm.moviedb.R
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.databinding.ActivityDetailMovieBinding
import com.idm.moviedb.utils.Constant

import com.idm.moviedb.vo.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.*

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity(){
    companion object {
        const val MOVIE_ID = "movie_id"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieID = intent.getIntExtra(MOVIE_ID, 0)
        Log.d("DETAILMOVIE","MOVIEID $movieID")

        detailMovieViewModel.getDetailMovie(movieID).observe(this,{
            Log.d("DETAILMOVIE","${it.status}")
            when (it.status) {
                Status.LOADING  -> {
                    binding.progressBar.isVisible = true
                }
                Status.SUCCESS -> {
                    it.data?.let { it1 -> bindData(it1) }
                    Log.d("DETAILMOVIEACTIVITY","ISI ${it.data}")

                    binding.progressBar.isVisible = false
                }
                Status.ERROR -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this@DetailMovieActivity,"Error when Load a Data", Toast.LENGTH_LONG).show()
                }
            }
        })

        binding.btnBack.setOnClickListener {
            finish()
        }


    }


    private fun bindData(movie: MovieEntity) {
        stateFavoriteIcon(movie.favorite)

        binding.btnSave.setOnClickListener {
            if (movie.favorite == false) {
                Snackbar.make(it, "Movie Saved to Favorite", Snackbar.LENGTH_SHORT).show()
            } else if (movie.favorite == true) {
                Snackbar.make(it, "Movie Deleted from Favorite", Snackbar.LENGTH_SHORT).show()
            }
            CoroutineScope(Dispatchers.IO).launch {
                detailMovieViewModel.updateMovie(movie)
            }
        }

        //getMovieItem
        with(binding) {
            Log.d("Detail", "Isi Detail $movie")
            tvTittle.text = movie.title
            val tagline = if (movie.tagline.isEmpty()) {
                "Tagline Not Found"
            } else {
                movie.tagline
            }
            tvTagline.text = tagline
            tvStatus.text = movie.status

            val listGenre = movie.genres.map {
                it.name
            }

            tvGenre.text = listGenre.joinToString()
            tvStoryline.text = movie.overview

            val budget = movie.budget
            val convertBudget = NumberFormat.getNumberInstance(Locale.US).format(budget)
            tvBudget.text = convertBudget

            val revenue = movie.revenue
            val convertRevenue = NumberFormat.getNumberInstance(Locale.US).format(revenue)
            tvRevenue.text = convertRevenue

            val star = movie.vote_average
            tvStar.text = star.toString()

            Log.d("IMAGEPATHDETAILMOVIE",Constant.IMAGE_PATH + movie.poster_path)

            Glide.with(this@DetailMovieActivity)
                .load(Constant.IMAGE_PATH + movie.poster_path)
                .transform(CenterCrop(), RoundedCorners(16))
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)


        }
    }

    private fun stateFavoriteIcon(state: Boolean) {
        if (state == true) {
            binding.btnSave.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.ic_favorite_active
                )
            )

        } else if (state == false) {
            binding.btnSave.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.ic_favorite_inactive
                )
            )
        }
    }
}