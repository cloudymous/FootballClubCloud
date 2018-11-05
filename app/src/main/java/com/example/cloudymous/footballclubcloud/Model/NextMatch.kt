package com.example.cloudymous.footballclubcloud.Model

import com.google.gson.annotations.SerializedName

data class NextMatch (
    @SerializedName("dateEvent")
    var eventDate : String? = null,

    @SerializedName("strHomeTeam")
    var teamHome : String? = null,

    @SerializedName("strAwayTeam")
    var teamAway : String? = null
)