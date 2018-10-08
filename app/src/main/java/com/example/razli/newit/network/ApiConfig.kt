package com.example.razli.newit.network

class ApiConfig private constructor() {

    companion object {

        // https://www.football-data.org/documentation/quickstart
        const val COMPETITIONS = "/v2/competitions" // List all available competitions.
        const val LEAGUE_TABLE = "/v2/competitions/{id}/standings" // Show Standings for a particular competition.
        const val TEAMS = "/v2/competitions/{id}/teams" // List all teams for a particular competition.
        const val TEAM = "/v2/teams/{id}" // Show one particular team.
        const val MATCH = "/v2/competitions/{id}/matches"

    }
}