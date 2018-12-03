package com.intive.selftraining.selftraining.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.Model
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.mock
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`

class MovieDetailsMapperTest {

    val mapper = mock<MovieDetailsMapper>()
    val movieDetail: MovieDetails = getMovieDetails()
    val movieDetailsEntity: MovieDetailsEntitiy = Model().getMovieDetailsEntity()
    val imagesEntity: ImagesEntity = Model().getImagesEntity()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `map from entity`() {
        `when`(mapper.mapFromEntity(movieDetailsEntity, imagesEntity)).thenReturn(movieDetail)
        mapper.mapFromEntity(movieDetailsEntity, imagesEntity) `should equal` movieDetail
    }

    fun getMovieDetails(): MovieDetails {
        val movieDetails = MovieDetails()
        movieDetails.backdropPath = "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg"
        movieDetails.genre = ""
        movieDetails.id = 335983
        movieDetails.overview = "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life."
        movieDetails.posterPath = "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"
        movieDetails.releaseDate = "2018-10-03"
        movieDetails.title = "Venom"
        movieDetails.voteAverage = 6.6
        movieDetails.completeImageUrl = "http://imagesEntity.tmdb.org/t/p/w500/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"

        return movieDetails
    }
}