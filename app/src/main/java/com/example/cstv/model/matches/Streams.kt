package com.example.cstv.model.matches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Streams(
    val embed_url: String,
    val language: String,
    val main: Boolean,
    val official: Boolean,
    val raw_url: String
) : Parcelable