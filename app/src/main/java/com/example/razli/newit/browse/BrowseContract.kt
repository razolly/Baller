package com.example.razli.newit.browse

import com.example.razli.newit.BasePresenter
import com.example.razli.newit.BaseView

interface BrowseContract {

    interface View : BaseView<BrowseContract.Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}