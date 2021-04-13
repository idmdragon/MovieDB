package com.idm.moviedb.ui.tvshow

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TVShowViewModelTest (){

    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getListMovie() {

        val tvShowEntities = viewModel.getTVShow()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(10, tvShowEntities.size)

    }
}