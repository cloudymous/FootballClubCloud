package com.example.cloudymous.footballclubcloud.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailMatch (

    @SerializedName("idEvent")
    var eventId : String? = null,

    @SerializedName("strDate")
    var eventDate : String? = null,

    @SerializedName("strTime")
    var eventTime : String? = null,

    @SerializedName("idHomeTeam")
    var homeTeamId : String? = null,

    @SerializedName("strHomeTeam")
    var homeTeam : String? = null,

    @SerializedName("idAwayTeam")
    var awayTeamId : String? = null,

    @SerializedName("strAwayTeam")
    var awayTeam : String? = null,

    @SerializedName("intHomeScore")
    var homeScore : String? = null,

    @SerializedName("intAwayScore")
    var awayScore : String? = null,

    @SerializedName("strHomeRedCards")
    var homeRedCards : String? = null,

    @SerializedName("strAwayRedCards")
    var awayRedCards : String? = null,

    @SerializedName("strHomeYellowCards")
    var homeYellowCards : String? = null,

    @SerializedName("strAwayYellowCards")
    var awayYellowCards : String? = null,

    @SerializedName("strHomeLineupGoalkeeper")
    var homeGoalKeeper : String? = null,

    @SerializedName("strAwayLineupGoalkeeper")
    var awayGoalKeeper : String? = null,

    @SerializedName("strHomeLineupDefense")
    var homeLineDefense : String? = null,

    @SerializedName("strAwayLineupDefense")
    var awayLineDefense : String? = null,

    @SerializedName("strHomeLineupMidfield")
    var homeLineMidfield : String? = null,

    @SerializedName("strAwayLineupMidfield")
    var awayLineMidfield : String? = null,

    @SerializedName("strHomeLineupForward")
    var homeLineForward : String? = null,

    @SerializedName("strAwayLineupForward")
    var awayLineForward : String? = null,

    @SerializedName("strHomeLineupSubstitutes")
    var homeSubtitutes : String? = null,

    @SerializedName("strAwayLineupSubstitutes")
    var awaySubtitutes : String? = null

) : Serializable {

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