package com.example.razli.newit.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        // Get Tier 1 competitions in England, Germany, Italy, Spain
        val areas = "${ApiConfig.COUNTRY_ENGLAND},${ApiConfig.COUNTRY_GERMANY},${ApiConfig.COUNTRY_ITALY},${ApiConfig.COUNTRY_SPAIN}"
        val plan = ApiConfig.TIER_ONE
        service.getCompetitions(areas, plan).enqueue(callback)
    }
}