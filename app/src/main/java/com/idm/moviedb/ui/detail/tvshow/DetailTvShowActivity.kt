package com.idm.moviedb.ui.detail.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.idm.moviedb.databinding.ActivityDetailTvshowBinding
import com.idm.moviedb.data.source.remote.tv.detail.TvDetailResponse
import com.idm.moviedb.utils.Constant
import java.util.*


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
        detailTvShowViewModel.setDetail(tvId)

        binding.btnBack.setOnClickListener {
            finish()
        }
        detailTvShowViewModel.detailMovie.observe(this,::bindData)

    }

    private fun bindData(tvShow: TvDetailResponse) {
        with(binding) {
            val taglineNotFound = "Tagline Not Found"
            val tagline = if (tvShow.tagline!=""){
                tvShow.tagline
            }else{
                taglineNotFound
            }
            tvTagline.text = tagline
            tvStatus.text = tvShow.status
            tvTittle.text = tvShow.name

            val listGenre  = tvShow.genres.map {
                it.name
            }

            tvGenre.text = listGenre.joinToString()
            tvStoryLine.text = tvShow.overview
            tvEpisodes.text = tvShow.number_of_episodes.toString()
            tvStar.text = tvShow.vote_average.toString()

            Glide.with(this@DetailTvShowActivity)
                .load(Constant.IMAGE_PATH +tvShow.poster_path)
                .transform(CenterCrop(), RoundedCorners(16))
                .placeholder(ColorDrawable(Color.GRAY))
                .into(ivPoster)


        }
    }


}