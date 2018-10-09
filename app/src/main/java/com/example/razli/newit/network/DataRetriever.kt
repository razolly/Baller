package com.example.razli.newit.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class DataRetriever {

    private val service: FootballDataApi  // retrofit2 interface

    companion object {
        const val BASE_URL = "http://api.football-data.org/"
    }


    val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        service = retrofit.create(FootballDataApi::class.java)
    }

    /**
     * Has a method to create a Retrofit Call object on which you enqueue() a network call,
     * passing in a Retrofit callback. A successful response body type is set to RepoResult
     */
    fun getCompetitionList(callback: Callback<CompetitionList>) {
        val areas = "${ApiConfig.COUNTRY_ENGLAND},${ApiConfig.COUNTRY_GERMANY},${ApiConfig.COUNTRY_ITALY},${ApiConfig.COUNTRY_SPAIN}"
        val plan = ApiConfig.TIER_ONE
        service.getCompetitions(areas, plan).enqueue(callback)
    }

    fun getTeamList(callback: Callback<LeagueSeason>) {
        val year = Calendar.getInstance().get(Calendar.YEAR).toString()
        val leagueIds = listOf(ApiConfig.ID_ENGLISH_PREMIER_LEAGUE,
                ApiConfig.ID_ENGLISH_CHAMPIONSHIP,
                ApiConfig.ID_BUNDESLIGA,
                ApiConfig.ID_LA_LIGA,
                ApiConfig.ID_SERIE_A)
        service.getLeagueTeams(leagueIds[0], year).enqueue(callback)
    }
}