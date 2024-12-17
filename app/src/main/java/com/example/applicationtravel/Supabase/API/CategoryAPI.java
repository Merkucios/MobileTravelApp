package com.example.applicationtravel.Supabase.API;

import com.example.applicationtravel.Domain.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryAPI {
    @GET("category")
    Call<List<Category>> getCategories();
}
