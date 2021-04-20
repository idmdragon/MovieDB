package com.idm.moviedb.ui.search

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.idm.moviedb.data.source.remote.movie.MovieResult
import com.idm.moviedb.data.source.remote.search.SearchResult
import com.idm.moviedb.databinding.ItemLayoutBinding
import com.idm.moviedb.databinding.SearchItemBinding
import com.idm.moviedb.utils.Constant
import java.util.*

class SearchViewHolder(private val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SearchResult) {
        with(binding) {
            tvTittle.text = item.title
            tvDate.text = item.release_date
            tvType.text = item.media_type.capitalize(Locale.ROOT)
            Glide.with(itemView.context)
                .load(Constant.IMAGE_PATH +item.backdrop_path)
                .transform(RoundedCorners(8))
                .centerCrop()
                .placeholder(ColorDrawable(Color.GRAY))
                .apply(RequestOptions().override(128, 164))
                .into(ivPoster)


        }

    }
}
