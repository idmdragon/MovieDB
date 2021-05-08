package com.idm.moviedb.ui.favorite.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.databinding.FragmentFavoriteMoviesBinding
import com.idm.moviedb.ui.movies.detail.DetailMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMoviesFragment : Fragment() {

    private val viewModel : FavoriteMovieViewModel by activityViewModels()
    private var _binding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllFavoriteMovie().observe(viewLifecycleOwner,::setFavoriteList)


    }

    private fun setFavoriteList(items: List<MovieDetailResponse>) {

        if(items.isEmpty()){
            binding.movieNotfound.isVisible = true
        }else{
            binding.movieNotfound.isVisible = false
            favoriteAdapter = FavoriteMovieAdapter(items)
            favoriteAdapter.notifyDataSetChanged()
            binding.rvFavMovie.layoutManager = LinearLayoutManager(activity,
                LinearLayoutManager.VERTICAL,false)
            binding.rvFavMovie.adapter = favoriteAdapter

            favoriteAdapter.setOnItemCallback(
                object : OnItemClickCallback {
                    override fun onItemClicked(movies: MovieDetailResponse) {
                        val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                        intent.putExtra(DetailMovieActivity.MOVIE_ID, movies.id)
                        startActivity(intent)
                    }
                }
            )
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}