package com.intive.selftraining.selftraining.viewmodel

import com.intive.selftraining.selftraining.repository.DetailsRepository

class DetailsScopeViewModel(val repo: DetailsRepository) {

    fun sayMovie() = "${repo.showDetails()}"
}