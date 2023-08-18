package com.example.cstv.networking.response.player

import com.google.gson.annotations.SerializedName

data class CurrentVideogame(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)