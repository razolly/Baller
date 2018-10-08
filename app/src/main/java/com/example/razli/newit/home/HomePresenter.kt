package com.example.razli.newit.home

class HomePresenter(private val view: HomeContract.View /*TODO add repo here*/) : HomeContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {

    }

}