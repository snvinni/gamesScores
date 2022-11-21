package com.example.wordcupgames.data.remote


sealed class MatchResultCall<T> {
    data class Success<T>(val data: T) : MatchResultCall<T>()
    data class Error<T>(val throwable: Exception) : MatchResultCall<T>() {
        companion object {
            const val GENERIC_MESSAGE = "Something went wrong"
        }
    }
}