package com.idm.moviedb.ui.favorite.tvshow

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.data.source.remote.response.tv.detail.TvDetailResponse
import com.idm.moviedb.databinding.FavoriteItemListBinding
import com.idm.moviedb.ui.tvshow.detail.DetailTvShowActivity
import com.idm.moviedb.utils.Constant

class FavoriteTvViewHolder (private val binding: FavoriteItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(tv: TvEntity) {
        with(binding) {
            tvTittle.text = tv.name

            val rate: Double = tv.vote_average / 2

            ratingBar.rating = rate.toFloat()

            Glide.with(itemView.context)
                .load(Constant.IMAGE_PATH + tv.poster_path)
                .transform(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions())
                .into(ivPoster)
            layoutItemList.setOnClickListener {
                val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.TV_ID, tv.id)
                itemView.context.startActivity(intent)
            }

        }

    }
}