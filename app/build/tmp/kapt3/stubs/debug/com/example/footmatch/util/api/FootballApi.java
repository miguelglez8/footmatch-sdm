package com.example.footmatch.util.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J%\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/footmatch/util/api/FootballApi;", "", "getMatch", "Lcom/example/footmatch/modelo/pojos/MatchToShow;", "matchId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMatchStats", "Lcom/example/footmatch/modelo/pojos/Stats;", "getMatchesBetweenDates", "Lcom/example/footmatch/modelo/pojos/MatchesBetweenDatesResult;", "dateFrom", "", "dateTo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FootballApi {
    
    @retrofit2.http.GET(value = "matches/")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMatchesBetweenDates(@retrofit2.http.Query(value = "dateFrom")
    @org.jetbrains.annotations.NotNull
    java.lang.String dateFrom, @retrofit2.http.Query(value = "dateTo")
    @org.jetbrains.annotations.NotNull
    java.lang.String dateTo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.footmatch.modelo.pojos.MatchesBetweenDatesResult> $completion);
    
    @retrofit2.http.GET(value = "matches/{matchId}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMatch(@retrofit2.http.Path(value = "matchId")
    int matchId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.footmatch.modelo.pojos.MatchToShow> $completion);
    
    @retrofit2.http.GET(value = "matches/{matchId}/head2head?limit=50")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMatchStats(@retrofit2.http.Path(value = "matchId")
    int matchId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.footmatch.modelo.pojos.Stats> $completion);
}