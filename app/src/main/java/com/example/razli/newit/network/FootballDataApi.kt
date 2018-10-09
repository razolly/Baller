package com.example.razli.newit.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootballDataApi {

    @Headers("X-Auth-Token: 8aa3507be8b2437faeda4d3c06e78a0d")
    @GET(ApiConfig.COMPETITIONS)
    fun getCompetitions(@Query("areas") areas: String,
                        @Query("plan") plan: String): Call<CompetitionList>

}