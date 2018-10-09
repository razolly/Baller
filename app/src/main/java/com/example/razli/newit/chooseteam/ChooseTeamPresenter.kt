package com.example.razli.newit.chooseteam

import android.util.Log
import com.bumptech.glide.Glide
import com.example.razli.newit.network.ApiConfig
import com.example.razli.newit.network.CompetitionList
import com.example.razli.newit.network.DataRetriever
import com.example.razli.newit.network.LeagueSeason
import com.example.razli.newit.utils.GlideApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChooseTeamPresenter(private val view: ChooseTeamContract.View) : ChooseTeamContract.Presenter {

    private val dataRetriever = DataRetriever()

    override fun start() {

    }

    override fun getCompetitionList() {
        dataRetriever.getCompetitionList(object : Callback<CompetitionList> {
            override fun onFailure(call: Call<CompetitionList>?, t: Throwable?) {
                Log.e("ChooseTeamPresenter", "Problem calling retrieving CompetitionList", t)
            }

            override fun onResponse(call: Call<CompetitionList>?, response: Response<CompetitionList>?) {
                response?.isSuccessful.let {
                    val competitionList = response?.body()?.competitions ?: mutableListOf()
                    view.showCompetitions(competitionList)
                }
            }
        })
    }

    override fun getLeagueTeamList() {
        dataRetriever.getTeamList(object : Callback<LeagueSeason> {
            override fun onFailure(call: Call<LeagueSeason>, t: Throwable) {
                Log.e("ChooseTeamPresenter", "Problem calling retrieving LeagueTeamList", t)
            }

            override fun onResponse(call: Call<LeagueSeason>, response: Response<LeagueSeason>) {
                response?.isSuccessful.let {
                    val leagueTeamList = response?.body()?.teams ?: emptyList()
                    view.showLeagueTeams(leagueTeamList)
                }
            }

        })
    }

}