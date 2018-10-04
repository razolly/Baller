package com.example.razli.newit.home

import com.example.razli.newit.BasePresenter
import com.example.razli.newit.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showHi(str: String)

    }

    interface Presenter : BasePresenter {

        fun processHi(name: String)

    }

}