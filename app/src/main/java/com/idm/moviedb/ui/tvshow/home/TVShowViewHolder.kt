package com.idm.moviedb.ui.tvshow.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.databinding.VerticalItemBinding
import com.idm.moviedb.utils.Constant
import java.text.SimpleDateFormat
import java.util.*

class TVShowViewHolder(private val binding: VerticalItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: TvResult) {
        with(binding) {

            val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(item.first_air_date)
            if (date!=null){
                val formattedDatesString = SimpleDateFormat("MMM dd, yyyy", Locale.US).format(date)
                tvDate.text = formattedDatesString
            }

            tvTittle.text = item.name
            val rate : Double = item.vote_average/2
            ratingBar.rating = rate.toFloat()

            Glide.with(itemView.context)
                .load(Constant.IMAGE_PATH +item.poster_path)
                .transform(CenterCrop(), RoundedCorners(8))
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions().override(128, 164))
                .into(ivPoster)

        }

    }
}
