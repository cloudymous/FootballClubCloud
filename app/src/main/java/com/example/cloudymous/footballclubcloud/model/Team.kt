package com.example.cloudymous.footballclubcloud.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("strTeamBadge")
    var teamBadge: String? = null,

    @SerializedName("intFormedYear")
    var teamFormatYear: String? = null,

    @SerializedName("strStadium")
    var teamStadium: String? = null,

    @SerializedName("strDescription")
    var teamDescription: String? = null
)