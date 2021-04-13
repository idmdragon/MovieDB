package com.idm.moviedb.ui.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.adapter.ListMovieAdapter
import com.idm.moviedb.databinding.FragmentMoviesBinding
import com.idm.moviedb.models.Movie
import com.idm.moviedb.ui.detail.movie.DetailMovieActivity

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private var _binding: FragmentMoviesBinding? = null
    private lateinit var adapter: ListMovieAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvMovies.layoutManager = LinearLayoutManager(activity)
        activity.apply {
            val listMovie : ArrayList<Movie> = moviesViewModel.getMovie()
                adapter = ListMovieAdapter(listMovie)
                adapter.notifyDataSetChanged()
                binding.rvMovies.adapter = adapter
                adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(movie: Movie) {
                            val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.MOVIE_TITLE, movie.title)
                            startActivity(intent)
                        }
                    }
                )
            }
        }
    }
