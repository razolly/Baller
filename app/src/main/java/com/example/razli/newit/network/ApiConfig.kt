package com.example.razli.newit.network

class ApiConfig private constructor() {

    companion object {

        const val API_KEY = "X-Auth-Token: 8aa3507be8b2437faeda4d3c06e78a0d"

        // Country Code
        const val COUNTRY_ENGLAND = "2072"
        const val COUNTRY_GERMANY = "2088"
        const val COUNTRY_ITALY = "2114"
        const val COUNTRY_SPAIN = "2224"

        // League Code
        const val LC_ENGLISH_PREMIER_LEAGUE = "PL"
        const val LC_ENGLISH_CHAMPIONSHIP = "ELC"
        const val LC_BUNDESLIGA = "BL1"
        const val LC_SERIE_A = "SA"
        const val LC_LA_LIGA = "PD"

        // Plan/Tiers
        const val TIER_ONE = "TIER_ONE"
        const val TIER_TWO = "TIER_TWO"

        // https://www.football-data.org/documentation/quickstart
        const val COMPETITIONS = "/v2/competitions" // List all available competitions.
        const val LEAGUE_TABLE = "/v2/competitions/{id}/standings" // Show Standings for a particular competition.
        const val TEAMS = "/v2/competitions/{id}/teams" // List all teams for a particular competition.
        const val TEAM = "/v2/teams/{id}" // Show one particular team.
        const val MATCH = "/v2/competitions/{id}/matches"

    }
}