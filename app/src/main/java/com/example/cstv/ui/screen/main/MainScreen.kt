package com.example.cstv.ui.screen.main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cstv.ui.components.MatchItem

@Composable
fun MainScreen(navController: NavController) {

    val viewModel: MainViewModel = hiltViewModel()


    val list = viewModel.matches.collectAsState()

    Column {
        Text(text = "Main")
        list.value?.let { checkedList ->
            Log.i("TAG", checkedList.toString())
            LazyColumn(){
                items(checkedList) { item ->
                    MatchItem(item = item)
                }
            }
        }
    }

}