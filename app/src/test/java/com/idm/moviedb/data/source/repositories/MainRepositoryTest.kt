package com.idm.moviedb.data.source.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.idm.moviedb.data.source.remote.ApiService
import com.idm.moviedb.utils.DummyMovie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class MainRepositoryTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(ApiService::class.java)
    private val repository = FakeMainRepository(remote)

    private val topMovies = DummyMovie.generateTopMovie()
    private val topMovie = topMovies[0]
//    private val movieResponses = DummyData.generateRemoteMovies()
//    private val movieResponse = movieResponses[0]
//    private val movieId = movieResponse.id
//    private val tvShowResponses = DummyData.generateRemoteTvShows()
//    private val tvShowResponse = tvShowResponses[0]
//    private val tvShowId = tvShowResponse.id

//    @Test
//    fun getTopMovies() {
//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
//                .onAllMoviesReceived(movieResponses)
//            null
//        }.`when`(remote).getMovies(any())
//
//        val movieEntities = LiveDataTestUtil.getValue(repository.getMovies())
//        verify(remote).getMovies(any())
//        assertNotNull(movieEntities)
//        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
//    }

//    @Test
//    fun getMovieById() {
//        doAnswer { invocation ->
//            (invocation.arguments[1] as RemoteDataSource.LoadMovieByIdCallback)
//                .onMovieReceived(movieResponse)
//            null
//        }.`when`(remote).getMovieById(eq(movieId), any())
//
//        val movieEntity = LiveDataTestUtil.getValue(repository.getMovieById(movieId))
//
//        verify(remote).getMovieById(eq(movieId), any())
//
//        assertNotNull(movieEntity)
//        assertEquals(movieResponse.id, movieEntity.id)
//        assertEquals(movieResponse.title, movieEntity.title)
//        assertEquals(movieResponse.description, movieEntity.description)
//        assertEquals(movieResponse.image, movieEntity.imagePath)
//        assertEquals(movieResponse.genres, movieEntity.genres)
//        assertEquals(movieResponse.director, movieEntity.director)
//    }
//
//    @Test
//    fun getTvShows() {
//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
//                .onAllTvShowsReceived(tvShowResponses)
//            null
//        }.`when`(remote).getTvShows(any())
//
//        val tvShowEntities = LiveDataTestUtil.getValue(repository.getTvShows())
//        verify(remote).getTvShows(any())
//        assertNotNull(tvShowEntities)
//        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.size.toLong())
//    }
//
//    @Test
//    fun getTvShowById() {
//        doAnswer { invocation ->
//            (invocation.arguments[1] as RemoteDataSource.LoadTvShowByIdCallback)
//                .onTvShowReceived(tvShowResponse)
//            null
//        }.`when`(remote).getTvShowById(eq(tvShowId), any())
//
//        val tvShowEntity = LiveDataTestUtil.getValue(repository.getTvShowById(tvShowId))
//
//        verify(remote).getTvShowById(eq(tvShowId), any())
//
//        assertNotNull(tvShowEntity)
//        assertEquals(tvShowResponse.id, tvShowEntity.id)
//        assertEquals(tvShowResponse.title, tvShowEntity.title)
//        assertEquals(tvShowResponse.description, tvShowEntity.description)
//        assertEquals(tvShowResponse.image, tvShowEntity.imagePath)
//        assertEquals(tvShowResponse.genres, tvShowEntity.genres)
//        assertEquals(tvShowResponse.creator, tvShowEntity.creator)
//    }
}