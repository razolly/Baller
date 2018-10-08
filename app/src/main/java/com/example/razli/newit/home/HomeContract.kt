package com.example.razli.newit.home

import com.example.razli.newit.BasePresenter
import com.example.razli.newit.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

    }

}