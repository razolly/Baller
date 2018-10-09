package com.example.razli.newit.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface FootballDataApi {

    @Headers(ApiConfig.API_KEY)
    @GET(ApiConfig.COMPETITIONS)
    fun getCompetitions(@Query("areas") areas: String,
                        @Query("plan") plan: String): Call<CompetitionList>

}