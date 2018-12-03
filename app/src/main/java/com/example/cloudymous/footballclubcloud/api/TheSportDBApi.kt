package com.example.cloudymous.footballclubcloud.api

import com.example.cloudymous.footballclubcloud.BuildConfig

object TheSportDBApi {

    fun getTeams(league: String?): String {
//        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
//            .appendPath("search_all_teams.php")
//            .appendQueryParameter("l", league)
//            .build()
//            .toString()
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getTeamDetail(teamID: String?): String {
//        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
//            .appendPath("lookupteam.php")
//            .appendQueryParameter("id", teamID)
//            .build()
//            .toString()
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + teamID
    }

    fun getLastMatch(leagueId: String?): String {
//        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
//            .appendPath("eventspastleague.php")
//            .appendQueryParameter("id", leagueId)
//            .build()
//            .toString()
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague/.php?id=" + leagueId

    }

    fun getNextMatch(leagueId: String?): String {
//        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
//            .appendPath("eventsnextleague.php")
//            .appendQueryParameter("id", leagueId)
//            .build()
//            .toString()
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventnextleague/.php?id=" + leagueId
    }

    fun getDetailMatch(eventId: String?): String {
//        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
//            .appendPath("api")
//            .appendPath("v1")
//            .appendPath("json")
//            .appendPath(BuildConfig.TSDB_API_KEY)
//            .appendPath("lookupevent.php")
//            .appendQueryParameter("id", eventId)
//            .build()
//            .toString()
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupevent/.php?id=" + eventId
    }

}