package com.parzival48.fakechef.model

import com.google.gson.annotations.SerializedName

data class AppProperties(
    @SerializedName("online")
    val online : Boolean,
    @SerializedName("version")
    val version : String,
    @SerializedName("theme")
    val theme : String,
    @SerializedName("note")
    val note : String
)