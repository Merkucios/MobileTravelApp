package com.example.applicationtravel.Supabase;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SupabaseClient {
    // Enter your  URL Supabase project
    // Example - https://qwerty.supabase.co/rest/v1/
    private static final String BASE_URL = "hack";
    // Enter yout public API_KEY 
    // Example - JhbGciOiJIUzI1NiIsInR5cCfdksla313dfY ...
    private static final String API_KEY = "hack";
    
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static OkHttpClient getClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder()
                                    .addHeader("apikey", API_KEY)
                                    .build();
                            Log.d("SupabaseClient", "Request URL: " + request.url());
                            Log.d("SupabaseClient", "Request Headers: " + request.headers());
                            Response response = chain.proceed(request);
                            Log.d("SupabaseClient", "Response Code: " + response.code());
                            Log.d("SupabaseClient", "Response Headers: " + response.headers());

                            return response;
                        }
                    })
                    .build();
        }
        return okHttpClient;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}