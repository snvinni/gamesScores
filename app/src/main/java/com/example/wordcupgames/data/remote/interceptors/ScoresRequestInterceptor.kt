package com.example.wordcupgames.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

object ScoresRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
            .newBuilder()
            .addHeader("X-Auth-Token", "fbe4ba3ae0494fad8e5f812a8ca2d031")
            .build()

        return chain.proceed(request)
    }

}