package com.example.applicationtravel.Supabase.API;

import com.example.applicationtravel.Domain.SliderItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerAPI {
    @GET("banner")
    Call<List<SliderItems>> getBanners();
}