package com.idm.moviedb.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.adapter.SearchAdapter
import com.idm.moviedb.data.models.search.SearchResult
import com.idm.moviedb.databinding.FragmentSearchBinding
import com.idm.moviedb.ui.movies.detail.DetailMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by activityViewModels()
    private var _binding: FragmentSearchBinding? = null
    private lateinit var adapter: SearchAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isEmpty()) {
                    shimmerLoading(false)
                } else {
                    shimmerLoading(true)
                    binding.tvResult.visibility = View.GONE
                    searchIlus(false)
                    searchViewModel.searchItem(query)
                    binding.searchNotfound.visibility = View.GONE
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })


        activity.apply {
            searchViewModel.searchItemList.observe(viewLifecycleOwner, ::showRv)
        }
    }

    private fun showRv(listSearch: ArrayList<SearchResult>?) {
        Log.d("SearchFramgnet","Isi list Search di Search Fragment")

        activity.apply {
            val sizeResult = "Search Result(${listSearch?.size})"
            if (listSearch?.size==0){
                binding.searchNotfound.visibility = View.VISIBLE
            }else{
                binding.searchNotfound.visibility = View.GONE
            }
            binding.tvResult.text = sizeResult
            if (listSearch != null) {
                with(binding) {
                    shimmerLoading(false)
                    searchIlus(false)

                    rvSearch.visibility = View.VISIBLE
                    binding.tvResult.visibility = View.VISIBLE
                    rvSearch.layoutManager = LinearLayoutManager(activity)

                    adapter = SearchAdapter(listSearch)
                    rvSearch.adapter = adapter
                }
                adapter.notifyDataSetChanged()

                adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(result: SearchResult) {
                            val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.MOVIE_ID, result.id)
                            startActivity(intent)
                        }
                    }
                )
            }

        }

    }

    private fun shimmerLoading(status: Boolean) {
        if (status) {
            binding.shimmerFrameLayout.showShimmer(true)
            binding.shimmerFrameLayout.visibility = View.VISIBLE
        } else {
            binding.shimmerFrameLayout.stopShimmer()
            binding.shimmerFrameLayout.visibility = View.GONE
        }

    }

    private fun searchIlus(status: Boolean) {
        binding.searchIlu.isVisible = status
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}