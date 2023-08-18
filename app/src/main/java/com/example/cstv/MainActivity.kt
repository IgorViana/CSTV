package com.example.cstv

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.cstv.ui.navigation.Navigation
import com.example.cstv.ui.theme.CSTVTheme
import com.example.cstv.util.PreferencesManager
import com.example.cstv.util.PreferencesManager.Companion.API_KEY
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSTVTheme {

                val ai: ApplicationInfo = applicationContext.packageManager
                    .getApplicationInfo(
                        applicationContext.packageName,
                        PackageManager.GET_META_DATA
                    )
                val key = ai.metaData.getString("APIkEY").toString()

                val preferencesManager = remember { PreferencesManager(applicationContext) }
                preferencesManager.saveKey(API_KEY, key)


                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}