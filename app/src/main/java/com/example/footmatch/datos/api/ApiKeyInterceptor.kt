package com.example.footmatch.datos.api

import okhttp3.Interceptor

import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val newRequest = originalRequest.newBuilder()
            .addHeader("X-Auth-Token", API_KEY)
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val API_KEY = "e1718a84ac1a4301a685e83a5a8d227a"
    }
}