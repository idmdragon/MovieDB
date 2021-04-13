package com.idm.moviedb.ui.tvshow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.R
import com.idm.moviedb.adapter.ListTVShowAdapter
import com.idm.moviedb.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {

    private val tvShowViewModel : TVShowViewModel by activityViewModels()
    private var _binding: FragmentTvShowBinding? = null
    private lateinit var adapter : ListTVShowAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShowViewModel.setMovie()


        binding.rvTvshow.layoutManager = LinearLayoutManager(activity)
        activity.apply {
        tvShowViewModel._listTVShow.observe(viewLifecycleOwner){
                adapter = ListTVShowAdapter(it)
                adapter.notifyDataSetChanged()
                binding.rvTvshow.adapter = adapter
            }
        }
    }
}