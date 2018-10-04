package com.example.razli.newit.bookmarks

import com.example.razli.newit.BasePresenter
import com.example.razli.newit.BaseView

interface BookmarksContract {

    interface View : BaseView<BookmarksContract.Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}