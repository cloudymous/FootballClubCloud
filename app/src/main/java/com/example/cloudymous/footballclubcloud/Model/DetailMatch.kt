package com.example.cloudymous.footballclubcloud.Model

import com.google.gson.annotations.SerializedName

data class DetailMatch (

    @SerializedName("dateEvent")
    var eventDate : String? = null,

    @SerializedName("strHomeTeam")
    var homeTeam : String? = null,

    @SerializedName("strAwayTeam")
    var awayTeam : String? = null,

    @SerializedName("intHomeScore")
    var homeScore : String? = null,

    @SerializedName("intAwayScore")
    var awayScore : String? = null

)