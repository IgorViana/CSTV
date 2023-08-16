package com.example.cstv.model.matches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class OpponentX(
    val acronym: @RawValue Any?,
    val id: Int,
    val image_url: String,
    val location: String,
    val modified_at: String,
    val name: String,
    val slug: String
) : Parcelable