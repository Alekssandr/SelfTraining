package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.intive.selftraining.selftraining.adapter.MoviesBinderAdapter
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.models.Result
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class ListMoviesViewModel(repo: ListMoviesRepositoryImpl) : ViewModel() {

//    private val disposable: Disposable = repo.showMovies().subscribe(
//                    { result -> getResponse(result) },
//                { error -> Log.e("ERROR", error.message) }
//            )

     val title = MutableLiveData<String>()


    private fun getResponse(result: List<Result>) {
        title.value = result[0].title

    }


    private val observable: Observable<MoviesResponse> = repo.showMovies()
    private var disposable: Disposable? = null

    fun getTitle(){
//        disposable = observable.map { title ->  title.results[0].title}
        disposable = observable.subscribe(
            { result -> getResponse(result.results) },
            { error -> Log.e("ERROR", error.message)})


    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}