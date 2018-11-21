package com.example.cloudymous.footballclubcloud.model

data class FavoriteMatch (val events : List<DetailMatch>
) {

    companion object {
        const val TABLE_FAVORITE_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
        const val EVENT_DATE: String = "EVENT_DATE"
        const val EVENT_TIME: String = "EVENT_TIME"
        const val EVENT_HOME_TEAM_ID: String = "EVENT_HOME_TEAM_ID"
        const val EVENT_HOME_BADGE: String = "EVENT_HOME_BADGE"
        const val EVENT_HOME_TEAM: String = "EVENT_HOME_TEAM"
        const val EVENT_AWAY_TEAM_ID: String = "EVENT_AWAY_TEAM_ID"
        const val EVENT_AWAY_BADGE: String = "EVENT_AWAY_BADGE"
        const val EVENT_AWAY_TEAM: String = "EVENT_AWAY_TEAM"
        const val EVENT_HOME_SCORE: String = "EVENT_HOME_SCORE"
        const val EVENT_AWAY_SCORE: String = "EVENT_AWAY_SCORE"
        const val EVENT_HOME_REDCARDS: String = "EVENT_HOME_REDCARDS"
        const val EVENT_AWAY_REDCARDS: String = "EVENT_AWAY_REDCARDS"
        const val EVENT_HOME_YELLOWCARDS: String = "EVENT_HOME_YELLOWCARDS"
        const val EVENT_AWAY_YELLOWCARDS: String = "EVENT_AWAY_YELLOWCARDS"
        const val EVENT_HOME_GOALKEEPER: String = "EVENT_HOME_GOALKEEPER"
        const val EVENT_AWAY_GOALKEEPER: String = "EVENT_AWAY_GOALKEEPER"
    }
}