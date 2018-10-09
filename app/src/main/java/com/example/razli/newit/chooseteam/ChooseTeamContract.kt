package com.example.razli.newit.chooseteam

import com.example.razli.newit.BasePresenter
import com.example.razli.newit.BaseView
import com.example.razli.newit.network.Competition
import com.example.razli.newit.network.Team

interface ChooseTeamContract {

    interface View : BaseView<ChooseTeamContract.Presenter> {

        fun showCompetitions(competitionList: List<Competition>)

        fun showLeagueTeams(leagueTeamList: List<Team>)

    }

    interface Presenter : BasePresenter {

        fun getCompetitionList()

        fun getLeagueTeamList()

    }

}