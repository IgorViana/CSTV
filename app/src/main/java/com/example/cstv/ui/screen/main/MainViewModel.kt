package com.example.cstv.ui.screen.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstv.model.MatchResponse
import com.example.cstv.repository.match.IMatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: IMatchRepository) : ViewModel() {

    private val _matches: MutableStateFlow<MatchResponse?> = MutableStateFlow(null)
    val matches = _matches.asStateFlow()

    init {
        getMatches()
    }

    fun getMatches() {
        viewModelScope.launch {
            val result = repository.getMatches().stateIn(viewModelScope)
            _matches.value = result.value
        }
    }
}