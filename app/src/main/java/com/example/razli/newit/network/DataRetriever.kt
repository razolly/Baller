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


//    val client = OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor()
//                    .setLevel(HttpLoggingInterceptor.Level.BODY))
//            .build()

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(FootballDataApi::class.java)
    }

    /**
     * Has a method to create a Retrofit Call object on which you enqueue() a network call,
     * passing in a Retrofit callback. A successful response body type is set to RepoResult
     */
    fun getCompetitionList(callback: Callback<CompetitionList>, areas: String, plan: String) {
        service.getCompetitions(areas, plan).enqueue(callback)
    }
}