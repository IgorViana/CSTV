package com.example.cstv.networking.response.player

import com.google.gson.annotations.SerializedName

data class Opponent(
    @SerializedName("acronym")
    val acronym: String,
    @SerializedName("current_videogame")
    val currentVideogame: CurrentVideogame,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("players")
    val players: List<Player>,
    @SerializedName("slug")
    val slug: String
)