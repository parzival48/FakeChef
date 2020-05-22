package com.parzival48.fakechef.model

import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("name") val name : String,
    @SerializedName("image") val image : String,
    @SerializedName("numOfTurns") var numOfTurns : Int
)