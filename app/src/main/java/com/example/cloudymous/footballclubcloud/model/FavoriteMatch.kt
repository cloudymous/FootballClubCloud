package com.example.cloudymous.footballclubcloud.model

data class FavoriteMatch(
    val id: Long?,
    val eventId: String?,
    val eventDate: String?,
    val eventTime: String?,
    val homeTeam: String?,
    val homeScore: String?,
    val awayTeam: String?,
    val awayScore: String?
) {

    companion object {
        const val TABLE_FAVORITE_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
        const val EVENT_DATE: String = "EVENT_DATE"
        const val EVENT_TIME: String = "EVENT_TIME"
        const val EVENT_HOME_TEAM: String = "EVENT_HOME_TEAM"
        const val EVENT_HOME_SCORE: String = "EVENT_HOME_SCORE"
        const val EVENT_AWAY_TEAM: String = "EVENT_AWAY_TEAM"
        const val EVENT_AWAY_SCORE: String = "EVENT_AWAY_SCORE"
    }
}