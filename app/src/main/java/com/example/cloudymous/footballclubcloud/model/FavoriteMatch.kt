package com.example.cloudymous.footballclubcloud.model

data class FavoriteMatch (val id: Long?,
                          val eventId: String?,
                          val eventDate: String?,
                          val eventTime: String?,
                          val homeTeamId: String?,
                          val awayTeamId: String?,
                          ) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val TEAM_ID: String = "TEAM_ID"
        const val TEAM_NAME: String = "TEAM_NAME"
        const val TEAM_BADGE: String = "TEAM_BADGE"
    }
}