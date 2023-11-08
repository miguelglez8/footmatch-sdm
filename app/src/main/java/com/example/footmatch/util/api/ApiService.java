package com.example.footmatch.util.api;

import com.example.footmatch.modelo.pojos.MatchResponse;
import com.example.footmatch.modelo.pojos.MatchesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("matches/{matchId}")
    Call<MatchResponse> getMatchData(@Path("matchId") String matchId);

    @GET("matches/")
    Call<MatchesResponse> getMatchesBetweenDates(@Query("dateFrom") String dateFrom,
                                                 @Query("dateTo") String dateTo);


}
