package com.example.cloudymous.footballclubcloud.model

data class FavoriteMatch (val events : List<DetailMatch>
) {

    companion object {
        const val TABLE_FAVORITE_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
        const val EVENT_DATE: String = "EVENT_DATE"
        const val EVENT_TIME: String = "EVENT_TIME"
        const val EVENT_HOME_TEAM: String = "EVENT_HOME_TEAM"
        const val EVENT_AWAY_TEAM: String = "EVENT_AWAY_TEAM"
    }
}