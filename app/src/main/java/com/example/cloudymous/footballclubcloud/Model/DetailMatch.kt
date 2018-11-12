package com.example.cloudymous.footballclubcloud.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailMatch (

    @SerializedName("idEvent")
    var eventId : String? = null,

    @SerializedName("dateEvent")
    var eventDate : String? = null,

    @SerializedName("strHomeTeam")
    var homeTeam : String? = null,

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

) : Serializable