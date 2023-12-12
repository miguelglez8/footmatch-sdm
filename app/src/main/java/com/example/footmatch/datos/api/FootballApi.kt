package com.example.footmatch.datos.api

import com.example.footmatch.datos.modelo.pojos.partido.MatchToShow
import com.example.footmatch.datos.modelo.pojos.partido.MatchesBetweenDatesResult
import com.example.footmatch.datos.modelo.pojos.clasificacion.StandingsResult
import com.example.footmatch.datos.modelo.pojos.plantilla.SquadResult
import com.example.footmatch.datos.modelo.pojos.partido.Stats
import com.example.footmatch.datos.modelo.pojos.partido.TeamX
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballApi {
    @GET("matches/")
    suspend fun getAllMatches(): com.example.footmatch.datos.modelo.pojos.partido.MatchesBetweenDatesResult
    @GET("matches/")
    suspend fun getMatchesBetweenDates(@Query("dateFrom") dateFrom: String,
                                       @Query("dateTo") dateTo: String): com.example.footmatch.datos.modelo.pojos.partido.MatchesBetweenDatesResult
    @GET("competitions/{code}/standings")
    suspend fun getStandingsFromLeague(
            @Path("code") code:String
    ): com.example.footmatch.datos.modelo.pojos.clasificacion.StandingsResult

    @GET("teams/{id}")
    suspend fun getSquadFromId(
        @Path("id") id:String
    ): com.example.footmatch.datos.modelo.pojos.plantilla.SquadResult
    @GET("matches/{matchId}")
    suspend fun getMatch(@Path("matchId") matchId: Int): com.example.footmatch.datos.modelo.pojos.partido.MatchToShow
    @GET("matches/{matchId}/head2head?limit=50")
    suspend fun getMatchStats(@Path("matchId") matchId: Int): com.example.footmatch.datos.modelo.pojos.partido.Stats
    @GET("teams/{teamId}")
    suspend fun getTeam(@Path("teamId") matchId: Int): com.example.footmatch.datos.modelo.pojos.partido.TeamX

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
