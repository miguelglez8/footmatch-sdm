package com.example.footmatch.util.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.atomic.AtomicInteger

class RequestsLimiterInterceptor : Interceptor {

    private var requestsCount = AtomicInteger(0)
    private var lastResetTime = System.currentTimeMillis()
    private val REQUESTS_LIMIT = 10
    private val REQUESTS_LIMIT_TIME = 60000

    @Synchronized
    fun checkRequestLimit(){
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastResetTime > REQUESTS_LIMIT_TIME){
            requestsCount.set(0)
            lastResetTime = currentTime
        }

    }

    @Synchronized
    fun incrementRequestCount(){
        requestsCount.incrementAndGet()
    }


    override fun intercept(chain: Interceptor.Chain): Response {
        checkRequestLimit()
        if(requestsCount.get() >= REQUESTS_LIMIT){
            // Calcular tiempo necesario de espera
            val timeToWait = REQUESTS_LIMIT_TIME - (System.currentTimeMillis() - lastResetTime)
            // Lanzamos excepcion cuando se supera el limite de peticiones
            Log.e("API-ERROR","Demasiadas requests a la API, espere $timeToWait")
            throw ApiLimitExceededException(timeToWait)
        }
        incrementRequestCount()
        return chain.proceed(chain.request())
    }

}