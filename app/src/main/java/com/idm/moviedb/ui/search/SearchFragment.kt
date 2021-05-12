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
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.response.search.SearchResult
import com.idm.moviedb.databinding.FragmentSearchBinding
import com.idm.moviedb.ui.movies.home.MoviePagedListAdapterHorizontal
import com.idm.moviedb.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by activityViewModels()
    private var _binding: FragmentSearchBinding? = null
    private lateinit var adapter: SearchPagedListAdapter
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
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    shimmerLoading(false)
                } else {
                    shimmerLoading(true)
                    binding.tvResult.visibility = View.GONE
                    searchIlus(false)
                    activity.apply {
                        searchViewModel.searchItem(newText).observe(viewLifecycleOwner,{
                            when (it.status) {
                                Status.LOADING -> {
                                }
                                Status.SUCCESS -> {
                                    it.data?.let { it1 -> searchBind(it1) }
                                }
                                Status.ERROR -> {
                                }
                            }
                        })
                    }

                    binding.searchNotfound.visibility = View.GONE
                }
                return true
            }
        })

    }

    private fun searchBind(items: PagedList<SearchResult>?) {

        activity.apply {
            val sizeResult = "Search Result(${items?.size})"
            if (items?.size==0){
                binding.searchNotfound.visibility = View.VISIBLE
            }else{
                binding.searchNotfound.visibility = View.GONE
            }
            binding.tvResult.text = sizeResult
            if (items != null) {
                with(binding) {
                    shimmerLoading(false)
                    searchIlus(false)
                    rvSearch.visibility = View.VISIBLE
                    tvResult.visibility = View.VISIBLE
                    rvSearch.layoutManager = LinearLayoutManager(activity)
                    adapter = SearchPagedListAdapter()
                    adapter.submitList(items)
                    adapter.notifyDataSetChanged()
                    rvSearch.adapter = adapter
                }

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