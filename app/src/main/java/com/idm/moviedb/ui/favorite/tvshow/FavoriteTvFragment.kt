package com.idm.moviedb.ui.favorite.tvshow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.data.source.remote.response.tv.detail.TvDetailResponse
import com.idm.moviedb.databinding.FragmentFavoriteTvBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteTvFragment : Fragment() {

    private val viewModel: FavoriteTvViewModel by activityViewModels()
    private var _binding: FragmentFavoriteTvBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoriteTvPagedListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllTvMovie().observe(viewLifecycleOwner, ::setFavoriteList)

    }

    private fun setFavoriteList(items: PagedList<TvEntity>) {
        Log.d("FavoriteMoviesFragment", "Isi $items")

        if (items.isEmpty()){
            binding.tvNotfound.isVisible = true
        }else{
            binding.tvNotfound.isVisible = false
            favoriteAdapter = FavoriteTvPagedListAdapter()
            favoriteAdapter.submitList(items)
            favoriteAdapter.notifyDataSetChanged()
            binding.rvFavTv.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL, false
            )
            binding.rvFavTv.adapter = favoriteAdapter

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}