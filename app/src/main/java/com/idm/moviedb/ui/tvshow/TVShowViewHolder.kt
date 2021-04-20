package com.idm.moviedb.ui.tvshow

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.source.remote.TVShow
import com.idm.moviedb.data.source.remote.tv.TvResult
import com.idm.moviedb.databinding.HorizontalItemBinding
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.utils.Constant

class TVShowViewHolder(private val binding: VerticalItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: TvResult) {
        with(binding) {

            tvDate.text = item.first_air_date
            tvTittle.text = item.name
            val rate : Double = item.vote_average/2
            ratingBar.rating = rate.toFloat()

            Glide.with(itemView.context)
                .load(Constant.IMAGE_PATH +item.poster_path)
                .transforms(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions().override(128, 164))
                .into(ivPoster)


        }

    }
}
