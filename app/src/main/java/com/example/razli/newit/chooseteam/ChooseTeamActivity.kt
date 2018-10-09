package com.example.razli.newit.chooseteam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.razli.newit.R
import com.example.razli.newit.network.Competition
import kotlinx.android.synthetic.main.activity_choose_team.*

class ChooseTeamActivity : AppCompatActivity(), ChooseTeamContract.View {

    override var presenter: ChooseTeamContract.Presenter = ChooseTeamPresenter(this)

    companion object {

        val EXTRA_CHOSEN_TEAM = "com.example.razli.newit.ChooseTeamActivity.EXTRA_CHOSEN_TEAM"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_team)

        presenter.getCompetitionList()
    }

    override fun showCompetitions(competitionList: List<Competition>) {
        competition_header.text = competitionList[0].name
    }
}
