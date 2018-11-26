package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.MutableLiveData
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.listmovies.model.Movies
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ListMoviesViewModelTest {

    var resultsList: MutableLiveData<List<Movies>> = mock {
        on { value } doReturn getMovieResponse()
    }

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `when should assert Movies`() {
        resultsList.value `should equal` getMovieResponse()
    }


    private fun getMovieResponse(): List<Movies> {

        val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
        val readOnlyList: List<Int> = numbers
        val mutList = mutableListOf<Movies>()

        var movies = Movies()
        movies.id = 1
        movies.title = "Fantastic Beasts: The Crimes of Grindelwald"
        movies.releaseDate = "2018-11-14"
        movies.posterPath = "/uyJgTzAsp3Za2TaPiZt2yaKYRIR.jpg"
        movies.adult = false
        movies.backdropPath = "/xgbeBCjmFpRYHDF7tQ7U98EREWp.jpg"
        movies.genreIds = readOnlyList
        movies.originalLanguage = "en"
        movies.originalTitle = "Fantastic Beasts: The Crimes of Grindelwald"
        movies.overview = "Gellert Grindelwald has escaped imprisonment and has begun gathering followers..."
        movies.popularity = 332.518
        movies.video = false
        movies.voteAverage = 7.1
        movies.voteCount = 1319
        movies.completeImageUrl = "/xgbeBCjmFpRYHDF7tQ7U98EREWp.jpg"

        mutList.add(movies)

        return mutList
    }
}