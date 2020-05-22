package com.parzival48.fakechef.model

import com.google.gson.annotations.SerializedName

data class Lobby(
    @SerializedName("code") val code : String,
    @SerializedName("fakeChef") val fakeChef : Int,
    @SerializedName("players") val players : List<Player>
)