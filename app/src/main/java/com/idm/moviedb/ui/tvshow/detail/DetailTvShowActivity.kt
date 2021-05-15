package com.idm.moviedb.ui.tvshow.detail

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
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.databinding.ActivityDetailTvshowBinding
import com.idm.moviedb.data.source.remote.response.tv.detail.TvDetailResponse
import com.idm.moviedb.data.source.remote.StatusResponse
import com.idm.moviedb.utils.Constant
import com.idm.moviedb.vo.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val TV_ID = "tv_id"
    }

    private lateinit var binding: ActivityDetailTvshowBinding
    private val detailTvShowViewModel: DetailTvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvId = intent.getIntExtra(TV_ID, 0)
        detailTvShowViewModel.getDetailTV(tvId).observe(this, {
            when (it.status) {
                Status.LOADING  -> {
                    binding.progressBar.isVisible = true
                }
                Status.SUCCESS -> {
                    it.data?.let { it1 -> bindData(it1) }
                    binding.progressBar.isVisible = false

                }
                Status.ERROR -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(this@DetailTvShowActivity,"Error when Load a Data", Toast.LENGTH_LONG).show()
                }
            }
        })



        binding.btnBack.setOnClickListener {
            finish()
        }

    }

    private fun bindData(tvShow: TvEntity) {
        stateFavoriteIcon(tvShow.favorite)
        binding.btnSave.setOnClickListener {
            if (tvShow.favorite == false) {
                Snackbar.make(it, "TV Show Saved to Favorite", Snackbar.LENGTH_SHORT).show()
            } else if (tvShow.favorite == true) {
                Snackbar.make(it, "TV Show Deleted from Favorite", Snackbar.LENGTH_SHORT).show()
            }
            CoroutineScope(Dispatchers.IO).launch {
                detailTvShowViewModel.updateTv(tvShow)
            }
        }

        with(binding) {

            val listGenre = tvShow.genres.map {
                it.name
            }
            tvGenre.text = listGenre.joinToString()
            val taglineNotFound = "Tagline Not Found"
            val tagline = if (tvShow.tagline != "") {
                tvShow.tagline
            } else {
                taglineNotFound
            }
            tvTagline.text = tagline
            tvStatus.text = tvShow.status
            tvTittle.text = tvShow.name
            tvStoryline.text = tvShow.overview
            tvEpisodes.text = tvShow.number_of_episodes.toString()
            tvStar.text = tvShow.vote_average.toString()

            Glide.with(this@DetailTvShowActivity)
                .load(Constant.IMAGE_PATH + tvShow.poster_path)
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