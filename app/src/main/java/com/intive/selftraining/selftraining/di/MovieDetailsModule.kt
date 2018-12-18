package com.intive.selftraining.selftraining.di

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsFragment
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.ErrorHandler
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class MovieDetailsModule {

    @ActivityScope
    @Provides
    fun provideMovieRepository(networkClient: NetworkInterface): MovieRepository {
        return MovieRepository(networkClient)
    }

    @ActivityScope
    @Provides
    fun provideMovieDetailsViewModelFactory(
        repo: MovieRepository,
        customScheduler: CustomScheduler,
        errorHandler: ErrorHandler
    ): MovieDetailsViewModelFactory {
        return MovieDetailsViewModelFactory(repo, customScheduler, errorHandler)
    }

    @ActivityScope
    @Provides
    fun provideMovieDetailsViewModel(
        fragment: MovieDetailsFragment,
        factory: MovieDetailsViewModelFactory
    ): MovieDetailsViewModel {
        return ViewModelProviders.of(fragment, factory).get(MovieDetailsViewModel::class.java)
    }
}