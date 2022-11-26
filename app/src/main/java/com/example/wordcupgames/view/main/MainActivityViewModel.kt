package com.example.wordcupgames.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordcupgames.data.remote.MatchResultCall
import com.example.wordcupgames.data.repositories.MatchRepository
import com.example.wordcupgames.model.Matches
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: MatchRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        MatchesUiState(matches = mutableListOf()),
    )
    val uiState: StateFlow<MatchesUiState> = _uiState.asStateFlow()

    init {
        if (uiState.value.matches.isEmpty()) {
            loadMatches(dateFrom = "2022-11-25", dateTo = "2022-11-26", competition = "WC")
        }
    }

    private fun loadMatches(dateFrom: String, dateTo: String, competition: String) {

        viewModelScope.launch {
            repository.getMatches(dateFrom, dateTo, competition).let { result ->
                when (result) {
                    is MatchResultCall.Success -> handleLoadMatchesSuccess(result.data)

                    is MatchResultCall.Error -> _uiState.update {
                        it.copy(
                            matches = listOf()
                        )
                    }
                }

            }
        }

    }

    private fun handleLoadMatchesSuccess(matches: List<Matches>) {
         _uiState.update {
             it.copy(
                 matches = matches
             )
         }

     }
}