package com.example.footmatch.datos.api

import com.example.footmatch.datos.modelos.partido.MatchToShow
import com.example.footmatch.datos.modelos.partido.MatchesBetweenDatesResult
import com.example.footmatch.datos.modelos.clasificacion.StandingsResult
import com.example.footmatch.datos.modelos.goleadores.Scorers
import com.example.footmatch.datos.modelos.plantilla.SquadResult
import com.example.footmatch.datos.modelos.partido.Stats
import com.example.footmatch.datos.modelos.partido.TeamX
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballApi {
    @GET("matches/")
    suspend fun getAllMatches(): MatchesBetweenDatesResult
    @GET("matches/")
    suspend fun getMatchesBetweenDates(@Query("dateFrom") dateFrom: String,
                                       @Query("dateTo") dateTo: String): MatchesBetweenDatesResult
    @GET("competitions/{code}/standings")
    suspend fun getStandingsFromLeague(
            @Path("code") code:String
    ):StandingsResult

    @GET("teams/{id}")
    suspend fun getSquadFromId(
        @Path("id") id:String
    ):SquadResult
    @GET("matches/{matchId}")
    suspend fun getMatch(@Path("matchId") matchId: Int): MatchToShow
    @GET("matches/{matchId}/head2head?limit=50")
    suspend fun getMatchStats(@Path("matchId") matchId: Int): Stats
    @GET("teams/{teamId}")
    suspend fun getTeam(@Path("teamId") matchId: Int): TeamX

    @GET("competitions/{code}/scorers")
    suspend fun getScorers(@Path("code") competitionId: String): Scorers

}

object RetrofitClient {
        fun makeClient(): FootballApi {
            // Creamos el interceptor que añade el API key
            val keyInterceptor = ApiKeyInterceptor()
            // Creamos el interceptor que limita las peticiones
            val requestsLimiterInterceptor = RequestsLimiterInterceptor()
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            // Establecemos los interceptores en el cliente HTTP
            httpClient.addInterceptor(keyInterceptor)
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor(requestsLimiterInterceptor)

            return Retrofit.Builder()
                .baseUrl("https://api.football-data.org/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(FootballApi::class.java)

        }
    }
