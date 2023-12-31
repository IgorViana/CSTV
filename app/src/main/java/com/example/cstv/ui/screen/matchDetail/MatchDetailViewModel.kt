package com.example.cstv.ui.screen.matchDetail

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstv.model.detail.DetailModel
import com.example.cstv.repository.IMatchDetailRepository
import com.example.cstv.util.PreferencesManager
import com.example.cstv.util.PreferencesManager.Companion.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    application: Application,
    savedStateHandle: SavedStateHandle,
    private val repository: IMatchDetailRepository
) : ViewModel() {

    private val id: Long = savedStateHandle.get<Long>("matchId") ?: 0L
    private val apiKey: String = PreferencesManager(application).getData(API_KEY, "")

    private val _state: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    init {
        getPlayersStatsByMatchId(id)
    }

    fun getPlayersStatsByMatchId(matchId: Long) {
        viewModelScope.launch {
            repository.getPlayersStatsByMatch(matchId = matchId, apiKey = apiKey)
                .stateIn(viewModelScope).collect { result ->
                result.onLoading { isLoading ->
                    _state.value = _state.value.copy(isLoading = isLoading)
                }.onSuccess { data ->
                    _state.value = _state.value.copy(detailResponse = data)
                }.onFailure { error ->
                    _state.value = _state.value.copy(error = error)
                }
            }
        }
    }
}

data class DetailState(
    val isLoading: Boolean = false,
    val detailResponse: DetailModel? = null,
    val error: String? = null
)