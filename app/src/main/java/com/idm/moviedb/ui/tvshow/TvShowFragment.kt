package com.idm.moviedb.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.adapter.ListTVShowAdapter
import com.idm.moviedb.databinding.FragmentTvShowBinding
import com.idm.moviedb.models.TVShow
import com.idm.moviedb.ui.detail.tvshow.DetailTvShowActivity

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


        binding.rvTvshow.layoutManager = LinearLayoutManager(activity)
        activity.apply {
            val listTVShow : ArrayList<TVShow> = tvShowViewModel.getTVShow()
                adapter = ListTVShowAdapter(listTVShow)
                adapter.notifyDataSetChanged()
                binding.rvTvshow.adapter = adapter

                adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(tvShow: TVShow) {
                            val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
                            intent.putExtra(DetailTvShowActivity.SHOW_TITLE, tvShow.title)
                            startActivity(intent)
                        }
                    }
                )
            }
    }
}