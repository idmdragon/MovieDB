package com.idm.moviedb.helper

import androidx.recyclerview.widget.DiffUtil
import com.idm.moviedb.data.response.movie.MovieResult

class NoteMovieDiffCallback(private val mOldMovieList : List<MovieResult>, private val mNewMovieList : List<MovieResult>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldMovieList.size
    }

    override fun getNewListSize(): Int {
        return mNewMovieList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldMovieList[oldItemPosition].id == mNewMovieList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldData = mOldMovieList[oldItemPosition]
        val newData = mNewMovieList[newItemPosition]
        return oldData.id == newData.id && oldData.id == newData.id && oldData.id == newData.id && oldData.id == newData.id
    }
}