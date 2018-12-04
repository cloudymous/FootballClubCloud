package com.example.cloudymous.footballclubcloud.api

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
        return "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=$league"
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
        return "https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$teamID"
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
        return "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=$leagueId"

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
        return "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=$leagueId"
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
        return "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=$eventId"
    }

}