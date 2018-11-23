package com.example.cloudymous.footballclubcloud.model

data class FavoriteMatch(
    var eventId: String? = null,

    var eventDate: String? = null,

    var eventTime: String? = null,

    var homeTeamId: String? = null,

    var homeTeam: String? = null,

    var awayTeamId: String? = null,

    var awayTeam: String? = null,

    var homeScore: String? = null,

    var awayScore: String? = null
) {
    companion object {
        const val TABLE_FAVORITE_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
        const val EVENT_DATE: String = "EVENT_DATE"
        const val EVENT_TIME: String = "EVENT_TIME"
        const val EVENT_HOME_TEAM_ID: String = "EVENT_HOME_TEAMID"
        const val EVENT_HOME_TEAM: String = "EVENT_HOME_TEAM"
        const val EVENT_AWAY_TEAM_ID: String = "EVENT_AWAY_TEAMID"
        const val EVENT_AWAY_TEAM: String = "EVENT_AWAY_TEAM"
        const val EVENT_HOME_SCORE: String = "EVENT_HOME_SCORE"
        const val EVENT_AWAY_SCORE: String = "EVENT_AWAY_SCORE"
    }
}