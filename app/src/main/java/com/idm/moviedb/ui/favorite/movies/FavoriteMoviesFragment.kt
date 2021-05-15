package com.idm.moviedb.ui.favorite.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.databinding.FragmentFavoriteMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment() {

    private val viewModel: FavoriteMovieViewModel by activityViewModels()
    private var _binding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoriteAdapter: FavoriteMoviePagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteAdapter = FavoriteMoviePagedListAdapter()
        favoriteAdapter.notifyDataSetChanged()
        binding.rvFavMovie.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner, ::setFavoriteList)

    }

    private fun setFavoriteList(items: PagedList<MovieEntity>) {
        if (items.isEmpty()) {
            binding.movieNotfound.isVisible = true
            favoriteAdapter.submitList(items)
        } else {
            binding.movieNotfound.isVisible = false
            favoriteAdapter.submitList(items)
        }
        binding.rvFavMovie.adapter = favoriteAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}