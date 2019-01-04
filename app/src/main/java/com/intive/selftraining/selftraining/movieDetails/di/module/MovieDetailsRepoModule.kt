package com.intive.selftraining.selftraining.movieDetails.di.module

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class MovieDetailsRepoModule {

    @FragmentScope
    @Provides
    fun provideRepo(networkInterface: NetworkInterface): MovieRepository {
        return MovieRepository(networkInterface)
    }
}