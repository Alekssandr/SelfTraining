package com.intive.selftraining.selftraining.di

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.listmovies.ListMoviesViewModel
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.ErrorHandler
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class ListMoviesModule {

    @ActivityScope
    @Provides
    fun provideListMoviesRepository(networkInterface: NetworkInterface): ListMoviesRepository {
        return ListMoviesRepository(networkInterface)
    }

    @ActivityScope
    @Provides
    fun listMoviesViewModelFactory(
        repo: ListMoviesRepository,
        customScheduler: CustomScheduler,
        errorHandler: ErrorHandler
    ): ListMoviesViewModelFactory {
        return ListMoviesViewModelFactory(repo, customScheduler, errorHandler)
    }

    @ActivityScope
    @Provides
    fun provideListMoviesViewModel(
        fragment: ListMoviesFragment,
        factory: ListMoviesViewModelFactory
    ): ListMoviesViewModel {
        return ViewModelProviders.of(fragment, factory).get(ListMoviesViewModel::class.java)
    }
}