package com.example.wordcupgames.data.repositories

import com.example.wordcupgames.data.services.MatchService
import com.example.wordcupgames.data.remote.MatchResultCall
import com.example.wordcupgames.data.remote.responses.toModel
import com.example.wordcupgames.model.Matches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MatchRepository @Inject constructor(
    private val service: MatchService
) {
    suspend fun getMatches(
        dateFrom: String,
        dateTo: String,
        competition: String
    ): MatchResultCall<List<Matches>> {

        return try {
            val response = withContext(Dispatchers.IO) {
                service.getMatches(dateFrom, dateTo, competition)
            }

            if (response.isSuccessful) {
                val matches = response.body()?.matches?.map { it.toModel() } ?: listOf()
                MatchResultCall.Success(matches)
            } else {
                MatchResultCall.Error(Exception())
            }

        } catch (e: Exception) {
            MatchResultCall.Error(e)

        }

    }

}
