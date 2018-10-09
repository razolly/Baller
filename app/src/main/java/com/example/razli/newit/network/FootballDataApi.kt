package com.example.razli.newit.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballDataApi {

    @GET(ApiConfig.COMPETITIONS)
    fun getCompetitions(@Query("areas") areas: String,
                        @Query("plan") plan: String): Call<CompetitionList>

}