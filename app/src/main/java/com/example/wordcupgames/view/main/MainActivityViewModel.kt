package com.example.wordcupgames.view.main

import android.annotation.SuppressLint
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
import java.time.LocalDate
import javax.inject.Inject

@SuppressLint("NewApi")
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: MatchRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        MatchesUiState(matches = mutableListOf()),
    )
    val uiState: StateFlow<MatchesUiState> = _uiState.asStateFlow()

    private val _dateState = MutableStateFlow(
        DateState(currentDate = LocalDate.now())
    )
    val dateState: StateFlow<DateState> = _dateState.asStateFlow()

    init {
        if (uiState.value.matches.isEmpty()) {
            loadMatches(
                dateFrom = dateState.value.currentDate.toString(),
                dateTo = dateState.value.currentDate.toString(),
                competition = "WC"
            )
        }
    }

    fun loadMatches(dateFrom: String, dateTo: String, competition: String) {

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

    fun handleNextDay(currentDate: LocalDate): LocalDate {
        val newDate = currentDate.plusDays(1)

        _dateState.update {
            it.copy(
                currentDate = newDate
            )
        }
        loadMatches(newDate.toString(), newDate.toString(), "WC")
        return newDate
    }

    fun handleBeforeDay(currentDate: LocalDate): LocalDate {
        val newDate = currentDate.minusDays(1)

        _dateState.update {
            it.copy(
                currentDate = newDate
            )
        }
        loadMatches(newDate.toString(), newDate.toString(), "WC")
        return newDate
    }

}