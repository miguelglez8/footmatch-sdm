package com.example.footmatch.datos.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.atomic.AtomicInteger

class RequestsLimiterInterceptor : Interceptor {

    private val HTTP_TOO_MANY_REQUESTS = 429


    override fun intercept(chain: Interceptor.Chain): Response {
       val response = chain.proceed(chain.request())
        if (response.code == HTTP_TOO_MANY_REQUESTS) {
            val timeToWait = response.header("x-requestcounter-reset")?.toLong() ?: 0
            //val timeToWait = response.header("Retry-After")?.toLong() ?: 0
            Log.d("INTERCEPTOR", "API limit exceeded. Waiting $timeToWait seconds")
            throw ApiLimitExceededException(timeToWait)
        }
        return response
    }

}