package com.example.cstv.networking.response.player

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("age")
    val age: Int,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("slug")
    val slug: String
)