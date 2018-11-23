package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse
import com.intive.selftraining.selftraining.network.models.ApiResult

class ListMoviesMapper {

    private var page: Int = 0
    private var totalPages: Int = 0
    private var totalResults: Int = 0
    var results: MutableList<Results> = mutableListOf()

    //Image data class model
    private var changeKeys: List<String> = emptyList()
    private var backdropSizes: List<String> = emptyList()
    private var baseImageUrl: String = ""
    private var logoSizes: List<String> = emptyList()
    private var posterSizes: List<String> = emptyList()
    private var profileSizes: List<String> = emptyList()
    private var secureImageBaseUrl: String = ""
    private var stillSizes: List<String> = emptyList()

    //Api Result data class model
    class Results  {
        var id: Int = 0
        var title: String = ""
        var releaseDate: String = ""
        var posterPath: String = ""
        var adult: Boolean = false
        var backdropPath: String = ""
        var genreIds: List<Int> = emptyList()
        var originalLanguage: String = ""
        var originalTitle: String = ""
        var overview: String = ""
        var popularity: Double = 0.0
        var video: Boolean = false
        var voteAverage: Double = 0.0
        var voteCount: Int = 0

        fun fromApi(apiResults: ApiResult){
            id = apiResults.id
            title = apiResults.title
            releaseDate = apiResults.release_date
            posterPath = apiResults.poster_path
            adult = apiResults.adult
            backdropPath = apiResults.backdrop_path
            genreIds = apiResults.genre_ids
            originalLanguage = apiResults.original_language
            originalTitle = apiResults.original_title
            overview = apiResults.overview
            popularity = apiResults.popularity
            video = apiResults.video
            voteAverage = apiResults.vote_average
            voteCount = apiResults.vote_count
        }

        //Special field for image url
        var completeImageUrl: String = ""
    }

    fun fromApi(apiMoviesResponse: ApiMoviesResponse, apiConfiguration: ApiConfiguration)= ListMoviesMapper().apply {

        page = apiMoviesResponse.page
        totalPages = apiMoviesResponse.total_pages
        totalResults = apiMoviesResponse.total_results

        var result = Results()
        var tempResults: MutableList<Results> = mutableListOf()

        var i = 0
        while (i != apiMoviesResponse.results.size) {

            result.fromApi(apiMoviesResponse.results[i])
            result.completeImageUrl = baseImageUrl + logoSizes + apiMoviesResponse.results[i].poster_path
            tempResults.add(result)
        }

        results.addAll(tempResults)

        changeKeys = apiConfiguration.change_keys
        backdropSizes = apiConfiguration.images.backdrop_sizes
        baseImageUrl = apiConfiguration.images.base_url
        logoSizes = apiConfiguration.images.logo_sizes
        posterSizes = apiConfiguration.images.poster_sizes
        profileSizes = apiConfiguration.images.profile_sizes
        secureImageBaseUrl = apiConfiguration.images.secure_base_url
        stillSizes = apiConfiguration.images.still_sizes
    }
}

