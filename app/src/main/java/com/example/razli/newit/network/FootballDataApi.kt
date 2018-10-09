package com.example.razli.newit.network

import retrofit2.Call
import retrofit2.http.*

interface FootballDataApi {

    @Headers(ApiConfig.API_KEY)
    @GET(ApiConfig.COMPETITIONS)
    fun getCompetitions(@Query("areas") areas: String,
                        @Query("plan") plan: String): Call<CompetitionList>

    @Headers(ApiConfig.API_KEY)
    @GET(ApiConfig.TEAMS)
    fun getLeagueTeams(@Path("id") leagueId: String,
                       @Query("season") year: String): Call<LeagueSeason>

}