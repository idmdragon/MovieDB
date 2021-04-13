package com.idm.moviedb.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.R
import com.idm.moviedb.adapter.ListMovieAdapter
import com.idm.moviedb.adapter.ListTVShowAdapter
import com.idm.moviedb.databinding.FragmentMoviesBinding
import com.idm.moviedb.databinding.FragmentTvShowBinding
import com.idm.moviedb.ui.tvshow.TVShowViewModel

class MoviesFragment : Fragment() {

    private val moviesViewModel : MoviesViewModel by activityViewModels()
    private var _binding: FragmentMoviesBinding? = null
    private lateinit var adapter : ListMovieAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesViewModel.setMovie()


        binding.rvMovies.layoutManager = LinearLayoutManager(activity)
        activity.apply {
            moviesViewModel._listMovie.observe(viewLifecycleOwner){
                adapter = ListMovieAdapter(it)
                adapter.notifyDataSetChanged()
                binding.rvMovies.adapter = adapter
            }
        }
    }

}