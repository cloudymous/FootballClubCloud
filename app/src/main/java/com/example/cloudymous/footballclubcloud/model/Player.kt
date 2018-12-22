package com.example.cloudymous.footballclubcloud.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Player(

    @SerializedName("idPlayer")
    var playerId: String? = null,

    @SerializedName("strThumb")
    var playerThumb: String? = null,

    @SerializedName("strCutout")
    var playerImage: String? = null,

    @SerializedName("strPlayer")
    var playerName: String? = null,

    @SerializedName("strPosition")
    var playerPosition: String? = null,

    @SerializedName("strHeight")
    var playerHeight: String? = null,

    @SerializedName("strWeight")
    var playerWeight: String? = null,

    @SerializedName("strDescriptionEN")
    var playerDescription: String? = null
) : Serializable