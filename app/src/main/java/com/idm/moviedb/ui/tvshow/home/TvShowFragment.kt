package com.idm.moviedb.ui.tvshow.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.source.local.entity.TvEntity
import com.idm.moviedb.databinding.FragmentTvShowBinding
import com.idm.moviedb.data.source.remote.response.tv.TvResult
import com.idm.moviedb.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private val tvShowViewModel: TVShowViewModel by activityViewModels()
    private var _binding: FragmentTvShowBinding? = null
    private lateinit var adapter: TvPagedListAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTvshow.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        activity.apply {
            tvShowViewModel.getTvPopular().observe(viewLifecycleOwner,{
                when (it.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        it.data?.let { it1 -> setTvShow(it1) }
                    }
                    Status.ERROR -> {
                    }
                }
            })


        }
    }

    private fun setTvShow(items: PagedList<TvEntity>) {
        adapter = TvPagedListAdapter()
        adapter.submitList(items)
        binding.rvTvshow.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.rvTvshow.visibility = View.VISIBLE
        binding.shimmerTopTV.stopShimmer()
        binding.shimmerTopTV.visibility = View.GONE

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}