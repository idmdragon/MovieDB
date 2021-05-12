package com.idm.moviedb.ui.movies.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.response.movie.MovieResult
import com.idm.moviedb.data.response.movie.toprated.MovieTopRated
import com.idm.moviedb.databinding.FragmentMoviesBinding
import com.idm.moviedb.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private lateinit var topRatedAdapter: MoviePagedListAdapterHorizontal
    private lateinit var nowPlayingAdapter: MoviePagedListAdapterVertical
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
            moviesViewModel.getTopRated().observe(viewLifecycleOwner,{
                        when (it.status) {
                            Status.LOADING -> {
                            }
                            Status.SUCCESS -> {
                                it.data?.let {
                                    topRatedAdapter = MoviePagedListAdapterHorizontal()
                                    topRatedAdapter.submitList(it)
                                    topRatedAdapter.notifyDataSetChanged()
                                    binding.rvTop.adapter = topRatedAdapter
                                    binding.rvTop.visibility = View.VISIBLE
                                    binding.shimmerFrameLayout2.stopShimmer()
                                    binding.shimmerFrameLayout2.visibility = View.GONE
                                }
                            }
                            Status.ERROR -> {
                            }
                        }
                })

            moviesViewModel.getNowPlaying().observe(viewLifecycleOwner,{
                when (it.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        it.data?.let {
                            nowPlayingAdapter = MoviePagedListAdapterVertical()
                            nowPlayingAdapter.submitList(it)
                            nowPlayingAdapter.notifyDataSetChanged()
                            binding.shimmerNowPlaying.stopShimmer()
                            binding.shimmerNowPlaying.visibility = View.GONE
                            binding.rvNp.adapter = nowPlayingAdapter
                        }
                    }
                    Status.ERROR -> {
                    }
                }
            })
            binding.rvTop.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            binding.rvNp.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        }
    }




    private fun setTopRated(items: PagedList<MovieTopRated>) {
        topRatedAdapter = MoviePagedListAdapterHorizontal()
        topRatedAdapter.submitList(items)
        topRatedAdapter.notifyDataSetChanged()
        binding.rvTop.adapter = topRatedAdapter
        binding.rvTop.visibility = View.VISIBLE
        binding.shimmerFrameLayout2.stopShimmer()
        binding.shimmerFrameLayout2.visibility = View.GONE


    }

    private fun setPlayingNow(items: PagedList<MovieResult>) {


    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    }

