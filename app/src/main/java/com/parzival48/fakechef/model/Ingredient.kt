package com.parzival48.fakechef.model

import com.google.gson.annotations.SerializedName

data class Ingredient (
    @SerializedName("name") val name : String,
    @SerializedName("image") val image : String,
    @SerializedName("type") val type : Int
)