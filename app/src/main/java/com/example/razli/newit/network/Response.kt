package com.example.razli.newit.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.GET
import retrofit2.http.Query

/*"id": 2021,
"area": {
    "id": 2072,
    "name": "England"
},
"name": "Premier League",
"code": "PL",
"emblemUrl": null,
"plan": "TIER_ONE",
"currentSeason": {
    "id": 151,
    "startDate": "2018-08-10",
    "endDate": "2019-05-12",
    "currentMatchday": 8,
    "winner": null
},
"numberOfAvailableSeasons": 26,
"lastUpdated": "2018-10-07T20:10:21Z"*/


@JsonClass(generateAdapter = true)
data class CompetitionResult(
        @Json(name = "plan")
        val competitionTier: String,
        @Json(name = "currentSeason")
        val seasonInfo: SeasonInfo,
        val lastUpdated: String
) {
}

@JsonClass(generateAdapter = true)
data class SeasonInfo(
        val currentMatchDay: Int
) {

}