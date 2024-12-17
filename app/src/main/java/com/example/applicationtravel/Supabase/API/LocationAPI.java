package com.example.applicationtravel.Supabase.API;

import com.example.applicationtravel.Domain.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationAPI {
    @GET("location")
    Call<List<Location>> getLocations();
}