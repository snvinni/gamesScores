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

    val matches = MutableLiveData<List<Matches>>()

    init {
        if (matches.value.isNullOrEmpty()) {
            loadMatches(dateFrom = "2022-11-20", dateTo = "2022-11-21", competition = "WC")
        }
    }

    fun loadMatches(dateFrom: String, dateTo: String, competition: String) {

        viewModelScope.launch {
            repository.getMatches(dateFrom, dateTo, competition).let { result ->
                when (result) {
                    is MatchResultCall.Success -> matches.value = result.data

                    is MatchResultCall.Error -> matches.value = listOf()
                }

            }
        }

    }

    /* private fun handleLoadMatchesSuccess(matches: List<Matches>) {
         _uiState.update {
             it.copy(
                 matches = matches
             )
         }

     }*/
}