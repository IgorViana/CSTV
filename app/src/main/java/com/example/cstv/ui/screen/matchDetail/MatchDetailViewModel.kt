package com.example.cstv.ui.screen.matchDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstv.model.DetailResponse
import com.example.cstv.repository.match.IMatchDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: IMatchDetailRepository
) : ViewModel() {

    private val id: Long = 825983 //savedStateHandle["matchId"] ?: 0L

    private val _state: MutableStateFlow<DetailState> = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    init {
        getPlayersStatsByMatchId(id)
    }

    private fun getPlayersStatsByMatchId(matchId: Long) {
        viewModelScope.launch {
            repository.getPlayersStatsByMatch(matchId).stateIn(viewModelScope).collect { result ->
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
    val detailResponse: DetailResponse? = null,
    val error: String? = null
)