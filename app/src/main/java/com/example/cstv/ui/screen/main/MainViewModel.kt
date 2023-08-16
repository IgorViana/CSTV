package com.example.cstv.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstv.model.matches.MatchResponse
import com.example.cstv.repository.match.IMatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: IMatchRepository) : ViewModel() {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        getMatches()
    }

    fun getMatches() {
        viewModelScope.launch {
            repository.getMatches().stateIn(viewModelScope).collect { result ->
                result.onLoading { isLoading ->
                    _state.value = _state.value.copy(isLoading = isLoading)
                }.onSuccess { data ->
                    _state.value = _state.value.copy(matches = data)
                }.onFailure { error ->
                    _state.value = _state.value.copy(error = error)
                }
            }
        }
    }
}

data class MainState(
    val isLoading: Boolean = false,
    val matches: MatchResponse? = null,
    val error: String? = null
)