package com.idm.moviedb.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.idm.moviedb.R
import com.idm.moviedb.adapter.ListMovieAdapter
import com.idm.moviedb.databinding.FragmentMoviesBinding
import com.idm.moviedb.databinding.FragmentSearchBinding
import com.idm.moviedb.ui.movies.MoviesViewModel


class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by activityViewModels()
    private var _binding: FragmentSearchBinding? = null
    private lateinit var adapter: ListMovieAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.searchItem("Naruto")

        searchViewModel.searchItemList.observe(viewLifecycleOwner) {
            Log.d("SEARCHFRAGMENT","isi list $it")
        }
    }
}