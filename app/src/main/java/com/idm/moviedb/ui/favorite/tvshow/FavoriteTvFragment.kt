package com.idm.moviedb.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idm.moviedb.data.response.tv.detail.TvDetailResponse
import com.idm.moviedb.databinding.FragmentFavoriteTvBinding
import com.idm.moviedb.ui.tvshow.detail.DetailTvShowActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteTvFragment : Fragment() {

    private val viewModel: FavoriteTvViewModel by activityViewModels()
    private var _binding: FragmentFavoriteTvBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoriteTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllTvMovie().observe(viewLifecycleOwner, ::setFavoriteList)

    }

    private fun setFavoriteList(items: List<TvDetailResponse>) {
        Log.d("FavoriteMoviesFragment", "Isi $items")

        if (items.isEmpty()){
            binding.tvNotfound.isVisible = true
        }else{
            binding.tvNotfound.isVisible = false
            favoriteAdapter = FavoriteTvAdapter(items)
            favoriteAdapter.notifyDataSetChanged()
            binding.rvFavTv.layoutManager = LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL, false
            )
            binding.rvFavTv.adapter = favoriteAdapter
            favoriteAdapter.setOnItemCallback(
                object : OnItemClickCallback {
                    override fun onItemClicked(tv: TvDetailResponse) {
                        val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
                        intent.putExtra(DetailTvShowActivity.TV_ID, tv.id)
                        startActivity(intent)
                    }
                }
            )
        }



    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}