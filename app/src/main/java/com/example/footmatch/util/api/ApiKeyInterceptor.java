package com.example.footmatch.util.api;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
public class ApiKeyInterceptor implements Interceptor {
    private static final String API_KEY = "e1718a84ac1a4301a685e83a5a8d227a";

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request newRequest = originalRequest.newBuilder()
                .addHeader("X-Auth-Token", API_KEY)
                .build();

        return chain.proceed(newRequest);
    }
}
