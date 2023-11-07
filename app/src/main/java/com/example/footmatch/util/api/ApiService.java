package com.example.footmatch.util.api;

import com.example.footmatch.modelo.pojos.Match;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("matches/{matchId}")
    Call<Match> obtenerDatosPartido(@Path("matchId") String matchId);
}
