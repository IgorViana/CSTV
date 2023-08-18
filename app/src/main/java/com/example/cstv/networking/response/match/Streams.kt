package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Streams(
    @SerializedName("embed_url")
    val embedUrl: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("main")
    val main: Boolean,
    @SerializedName("official")
    val official: Boolean,
    @SerializedName("raw_url")
    val rawUrl: String
) : Parcelable