package com.idm.moviedb.ui.movies.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.databinding.FragmentMoviesBinding
import com.idm.moviedb.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private lateinit var nowPlayingAdapter: MoviePagedListAdapter
    private var _binding: FragmentMoviesBinding? = null
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


        activity.apply {
            moviesViewModel.getNowPlaying().observe(viewLifecycleOwner,{
                when (it.status) {
                    Status.LOADING -> {
                        binding.shimmerNowPlaying.startShimmer()
                    }
                    Status.SUCCESS -> {
                        it.data?.let { item ->
                            nowPlayingAdapter = MoviePagedListAdapter()
                            nowPlayingAdapter.submitList(item)
                            Log.d("MoviesFragment","Cek $item")
                            nowPlayingAdapter.notifyDataSetChanged()
                            binding.shimmerNowPlaying.stopShimmer()
                            binding.shimmerNowPlaying.visibility = View.GONE
                            binding.rvNp.adapter = nowPlayingAdapter
                        }
                    }
                    Status.ERROR -> {
                        binding.shimmerNowPlaying.stopShimmer()
                        Toast.makeText(requireContext(),"Error when Load a Data", Toast.LENGTH_LONG).show()

                    }
                }
            })
            binding.rvNp.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    }

