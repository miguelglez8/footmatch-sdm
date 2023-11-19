package com.example.footmatch.util.api

import com.example.footmatch.modelo.pojos.MatchesBetweenDatesResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {
    @GET("matches/")
    suspend fun getMatchesBetweenDates(@Query("dateFrom") dateFrom: String,
                                       @Query("dateTo") dateTo: String): MatchesBetweenDatesResult


}

object RetrofitClient {
        fun makeClient(): FootballApi {
            // Creamos el interceptor que añade el API key
            val keyInterceptor = ApiKeyInterceptor()
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            // Establecemos los interceptores en el cliente HTTP
            httpClient.addInterceptor(keyInterceptor)
            httpClient.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl("https://api.football-data.org/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(FootballApi::class.java)

        }
    }
