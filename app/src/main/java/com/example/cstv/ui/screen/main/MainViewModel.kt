package com.example.cstv.ui.screen.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstv.model.match.MatchListModel
import com.example.cstv.networking.response.match.MatchResponse
import com.example.cstv.repository.IMatchRepository
import com.example.cstv.util.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: IMatchRepository
) : ViewModel() {

    private val apiKey: String = PreferencesManager(application).getData(PreferencesManager.API_KEY, "")

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        getMatches()
    }

    fun getMatches() {
        viewModelScope.launch {
            repository.getMatches(apiKey).stateIn(viewModelScope).collect { result ->
                result.onLoading { isLoading ->
                    _state.value = _state.value.copy(isLoading = isLoading)
                }.onSuccess { data ->
                    _state.value = _state.value.copy(data = data)
                }.onFailure { error ->
                    _state.value = _state.value.copy(error = error)
                }
            }
        }
    }
}

data class MainState(
    val isLoading: Boolean = false,
    val data: MatchListModel? = null,
    val error: String? = null
)