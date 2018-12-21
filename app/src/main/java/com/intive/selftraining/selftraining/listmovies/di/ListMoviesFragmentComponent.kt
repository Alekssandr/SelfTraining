package com.intive.selftraining.selftraining.listmovies.di

import com.intive.selftraining.selftraining.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(ListMoviesModule::class))
interface ListMoviesFragmentComponent : AndroidInjector<ListMoviesFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ListMoviesFragment>()
}