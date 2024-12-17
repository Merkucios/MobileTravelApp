package com.example.applicationtravel.Supabase.API;

import com.example.applicationtravel.Domain.ItemDomain;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PopularItemsAPI {
    @GET("popular")
    Call<List<ItemDomain>> getPopularItems();

}
