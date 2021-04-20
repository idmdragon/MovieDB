package com.idm.moviedb.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.adapter.SearchAdapter
import com.idm.moviedb.data.source.remote.TVShow
import com.idm.moviedb.data.source.remote.search.SearchResult
import com.idm.moviedb.databinding.FragmentSearchBinding
import com.idm.moviedb.ui.detail.tvshow.DetailTvShowActivity
import com.idm.moviedb.ui.search.OnItemClickCallback


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
        // Inflate the layout for this fragment
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
                    searchIlus(false)
                    searchViewModel.searchItem(query)
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
        activity.apply {
            val sizeResult = "Search Result(${listSearch?.size})"
            binding.tvResult.text = sizeResult
            if (listSearch != null) {
                with(binding) {
                    shimmerLoading(false)
                    searchIlus(false)
                rvSearch.visibility = View.VISIBLE
                rvSearch.layoutManager = LinearLayoutManager(activity)
                adapter = SearchAdapter(listSearch)
                rvSearch.adapter = adapter
                }
                adapter.notifyDataSetChanged()

                adapter.setOnItemCallback(
                    object : OnItemClickCallback {
                        override fun onItemClicked(result: SearchResult) {
                            Toast.makeText(requireContext(),"title ${result.title}",Toast.LENGTH_LONG).show()
//                            val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
//                            intent.putExtra(DetailTvShowActivity.SHOW_TITLE, tvShow.title)
//                            startActivity(intent)
                        }
                    }
                )
            }

        }

    }

    private fun shimmerLoading(status : Boolean){
        if(status){
            binding.shimmerFrameLayout.showShimmer(true)
            binding.shimmerFrameLayout.visibility = View.VISIBLE
        }else{
            binding.shimmerFrameLayout.stopShimmer()
            binding.shimmerFrameLayout.visibility = View.GONE
        }

    }
    private fun searchIlus(status : Boolean){
            binding.searchIlu.isVisible = status
    }
}