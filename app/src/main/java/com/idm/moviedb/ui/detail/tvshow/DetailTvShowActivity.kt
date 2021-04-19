package com.idm.moviedb.ui.detail.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.idm.moviedb.databinding.ActivityDetailTvshowBinding
import com.idm.moviedb.data.source.remote.TVShow
import java.util.*


class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val SHOW_TITLE = "show_title"
    }

    private lateinit var binding: ActivityDetailTvshowBinding
    private val detailTvShowViewModel: DetailTvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(SHOW_TITLE)
        if (title != null) {
            detailTvShowViewModel.setItem(title)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
        val tvShow : TVShow = detailTvShowViewModel.getItem()
        bindData(tvShow)
    }

    private fun bindData(tvShow: TVShow?) {
        with(binding) {
            if (tvShow != null) {
                Log.d("DETAILTV","isi tv show $tvShow")
                tvTittle.text = tvShow.title
                tvDirector.text = tvShow.creator
                tvGenre.text = tvShow.genre
                tvStoryLine.text = tvShow.storyLine

                val star = tvShow.star.toDouble().div(10)
                tvStar.text = star.toString()

                Glide.with(this@DetailTvShowActivity)
                    .load(tvShow.poster)
                    .transform(CenterCrop(), RoundedCorners(16))
                    .placeholder(ColorDrawable(Color.GRAY))
                    .into(ivPoster)


            }
        }
    }


}