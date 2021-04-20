package com.idm.moviedb.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idm.moviedb.adapter.ListMovieAdapter
import com.idm.moviedb.adapter.ListVerticalMovieAdapter
import com.idm.moviedb.data.source.remote.movie.MovieResult
import com.idm.moviedb.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private var _binding: FragmentMoviesBinding? = null
    private lateinit var topRatedAdapter: ListMovieAdapter
    private lateinit var nowPlayingAdapter: ListVerticalMovieAdapter
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
        moviesViewModel.getTopRated()
        moviesViewModel.getNowPlaying()

        activity.apply {

            moviesViewModel.listTopRated.observe(viewLifecycleOwner,::setTopRated)
            moviesViewModel.listPlayingNow.observe(viewLifecycleOwner,::setPlayingNow)
            binding.rvTop.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            binding.rvNp.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        }


}

    private fun setTopRated(topRated: ArrayList<MovieResult>) {
        topRatedAdapter = ListMovieAdapter(topRated)
        Log.d("MoviesFragment","isi Top $topRated")
        topRatedAdapter.notifyDataSetChanged()
        binding.rvTop.adapter = topRatedAdapter
        binding.rvTop.visibility = View.VISIBLE
        binding.shimmerFrameLayout2.stopShimmer()
        binding.shimmerFrameLayout2.visibility = View.GONE
    }

    private fun setPlayingNow(playingNow: ArrayList<MovieResult>) {
        Log.d("MoviesFragment","isi Now Playing $playingNow")
        nowPlayingAdapter = ListVerticalMovieAdapter(playingNow)
        nowPlayingAdapter.notifyDataSetChanged()

        binding.shimmerNowPlaying.stopShimmer()
        binding.shimmerNowPlaying.visibility = View.GONE
        binding.rvNp.adapter = nowPlayingAdapter
//        adapter.setOnItemCallback(
//            object : OnItemClickCallback {
//                override fun onItemClicked(movie: MovieResult) {
//                    val intent = Intent(requireContext(), DetailMovieActivity::class.java)
//                    intent.putExtra(DetailMovieActivity.MOVIE_TITLE, movie.title)
//                    startActivity(intent)
//                }
//            }
//        )
    }
    }

