package com.intive.selftraining.selftraining.listmovies.di

import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ListMoviesFragmentComponent::class))
abstract class ListMoviesFragmentBinder {

    @Binds
    @IntoMap
    @FragmentKey(ListMoviesFragment::class)
    abstract fun bindListMoviesFragmentInjectorFactory(builder: ListMoviesFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}