package com.example.cloudymous.footballclubcloud.Model

import com.google.gson.annotations.SerializedName


data class LastMatch (
    @SerializedName("strEvent")
    var eventName : String? = null
)
