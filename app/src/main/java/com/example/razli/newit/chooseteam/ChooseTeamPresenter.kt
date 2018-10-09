package com.example.razli.newit.chooseteam

import android.util.Log
import com.example.razli.newit.network.ApiConfig
import com.example.razli.newit.network.CompetitionList
import com.example.razli.newit.network.DataRetriever
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChooseTeamPresenter(private val view: ChooseTeamContract.View) : ChooseTeamContract.Presenter {

    private val dataRetriever = DataRetriever()

    private val callback = object : Callback<CompetitionList> {
        override fun onFailure(call: Call<CompetitionList>?, t: Throwable?) {
            Log.e("ChooseTeamPresenter", "Problem calling Soccer-Data API", t)
        }

        override fun onResponse(call: Call<CompetitionList>?, response: Response<CompetitionList>?) {
            response?.isSuccessful.let {
                val competitionList = response?.body()?.competitions ?: mutableListOf()
                view.showCompetitions(competitionList)
            }
        }
    }

    override fun start() {

    }

    override fun getCompetitionList() {
        dataRetriever.getCompetitionList(callback)
    }

}