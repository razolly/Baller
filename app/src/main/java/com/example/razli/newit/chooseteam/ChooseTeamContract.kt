package com.example.razli.newit.chooseteam

import com.example.razli.newit.BasePresenter
import com.example.razli.newit.BaseView
import com.example.razli.newit.network.Competition

interface ChooseTeamContract {

    interface View : BaseView<ChooseTeamContract.Presenter> {

        fun showCompetitions(competitionList: List<Competition>)

    }

    interface Presenter : BasePresenter {

        fun getCompetitionList()

    }

}