package com.idm.moviedb.ui.favorite

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idm.moviedb.ui.favorite.movies.FavoriteMoviesFragment
import com.idm.moviedb.ui.favorite.tvshow.FavoriteTvFragment


class FavoriteViewPagerAdapter( fm : Fragment) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
       return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMoviesFragment()
            1 -> fragment  = FavoriteTvFragment()
        }
        return fragment as Fragment
    }


}
