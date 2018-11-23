package com.example.cloudymous.footballclubcloud.model

data class FavoriteMatch(

    val id: Long?,

    val eventId: String? = null,

    val eventDate: String? = null,

    val eventTime: String? = null,

    val homeTeamId: String? = null,

    val homeTeam: String? = null,

    val awayTeamId: String? = null,

    val awayTeam: String? = null,

    val homeScore: String? = null,

    val awayScore: String? = null
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