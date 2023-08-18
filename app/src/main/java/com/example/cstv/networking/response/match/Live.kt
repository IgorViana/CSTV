package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Live(
    @SerializedName("opens_at")
    val opensAt: @RawValue Any?,
    @SerializedName("supported")
    val supported: Boolean,
    @SerializedName("url")
    val url: @RawValue Any?
) : Parcelable