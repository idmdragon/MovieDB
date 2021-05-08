package com.idm.moviedb.ui.tvshow.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.adapter.ListTVShowAdapter
import com.idm.moviedb.databinding.FragmentTvShowBinding
import com.idm.moviedb.data.response.tv.TvResult
import com.idm.moviedb.ui.tvshow.detail.DetailTvShowActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private val tvShowViewModel: TVShowViewModel by activityViewModels()
    private var _binding: FragmentTvShowBinding? = null
    private lateinit var adapter: ListTVShowAdapter
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
            tvShowViewModel.getTvPopular().observe(viewLifecycleOwner) {
                Log.d("TVSHOWFRAGMENT","Isi listTvPopular $it")
                adapter = ListTVShowAdapter(it)
                adapter.notifyDataSetChanged()
                binding.shimmerTopTV.stopShimmer()
                binding.shimmerTopTV.visibility = View.GONE
                binding.rvTvshow.adapter = adapter

                adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(tvShow: TvResult) {
                            val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
                            intent.putExtra(DetailTvShowActivity.TV_ID, tvShow.id)
                            startActivity(intent)
                        }
                    }
                )
            }

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}