package com.example.cstv.util

import android.os.Bundle
import androidx.navigation.NavType
import com.example.cstv.model.matches.MatchResponseItem
import com.google.gson.Gson

class MatchResponseItemParamType : NavType<MatchResponseItem>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): MatchResponseItem? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): MatchResponseItem {
        return Gson().fromJson(value, MatchResponseItem::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: MatchResponseItem) {
        bundle.putParcelable(key, value)
    }
}