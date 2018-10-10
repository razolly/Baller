package com.example.razli.newit.network

import com.google.gson.annotations.SerializedName

/* --------------------------------- Leagues --------------------------------- */

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

data class CompetitionList(
        val competitions: MutableList<Competition>
) {
}

/*"competition": {
    "id": 2021,
    "area": {
        "id": 2072,
        "name": "England"
    },
    "name": "Premier League",
    "code": "PL",
    "plan": "TIER_ONE",
    "lastUpdated": "2018-10-08T15:10:08Z"
}*/
data class Competition(
        val name: String,
        val code: String,
        val currentSeason: SeasonInfo,
        val lastUpdated: String
) {
}

/*"season": {
    "id": 151,
    "startDate": "2018-08-10",
    "endDate": "2019-05-12",
    "currentMatchday": 8,
    "winner": null
}*/
data class SeasonInfo(
        val id: Int,
        val currentMatchday: Int
) {
}

/* --------------------------------- Teams --------------------------------- */

data class LeagueSeason(
        val teams: List<Team>
) {

}

/*"teams": [
{
    "id": 57,
    "area": {
    "id": 2072,
    "name": "England"
},
    "name": "Arsenal FC",
    "shortName": "Arsenal",
    "tla": "ARS",
    "crestUrl": "http://upload.wikimedia.org/wikipedia/en/5/53/Arsenal_FC.svg",
    "address": "75 Drayton Park London N5 1BU",
    "phone": "+44 (020) 76195003",
    "website": "http://www.arsenal.com",
    "email": "info@arsenal.co.uk",
    "founded": 1886,
    "clubColors": "Red / White",
    "venue": "Emirates Stadium",
    "lastUpdated": "2018-10-08T15:08:14Z"
},
{
    "id": 61,
    "area": {
    "id": 2072,
    "name": "England"
},
    "name": "Chelsea FC",
    "shortName": "Chelsea",
    "tla": "CFC",
    "crestUrl": "http://upload.wikimedia.org/wikipedia/de/5/5c/Chelsea_crest.svg",
    "address": "Fulham Road London SW6 1HS",
    "phone": "+44 (0871) 9841955",
    "website": "http://www.chelseafc.com",
    "email": null,
    "founded": 1905,
    "clubColors": "Royal Blue / White",
    "venue": "Stamford Bridge",
    "lastUpdated": "2018-10-08T15:08:16Z"
},*/
data class Team(
        val name: String,
        val shortName: String,
        @SerializedName("tla")
        val initial: String,
        val crestUrl: String?,
        val website: String,
        val clubColors: String,
        @SerializedName("venue")
        val stadium: String
) {

}