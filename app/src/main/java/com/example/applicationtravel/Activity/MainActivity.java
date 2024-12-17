package com.example.applicationtravel.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.applicationtravel.Adapter.CategoryAdapter;
import com.example.applicationtravel.Adapter.PopularAdapter;
import com.example.applicationtravel.Adapter.RecommendedAdapter;
import com.example.applicationtravel.Adapter.SliderAdapter;
import com.example.applicationtravel.Domain.Category;
import com.example.applicationtravel.Domain.ItemDomain;
import com.example.applicationtravel.Domain.Location;
import com.example.applicationtravel.Domain.SliderItems;
import com.example.applicationtravel.R;
import com.example.applicationtravel.Supabase.API.BannerAPI;
import com.example.applicationtravel.Supabase.API.CategoryAPI;
import com.example.applicationtravel.Supabase.API.LocationAPI;
import com.example.applicationtravel.Supabase.API.PopularItemsAPI;
import com.example.applicationtravel.Supabase.API.RecommendedItemAPI;
import com.example.applicationtravel.Supabase.SupabaseClient;
import com.example.applicationtravel.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        setContentView(binding.getRoot());

        initLocation();
        initBanner();
        initCategory();
        initRecommended();
        initPopular();
    }

    private void initLocation() {
        Log.d("MainActivity", "initLocation: Requesting locations");
        LocationAPI locationApi = SupabaseClient.getInstance().create(LocationAPI.class);

        locationApi.getLocations().enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("MainActivity", "onResponse: Locations fetched successfully");
                    ArrayList<Location> list = new ArrayList<>(response.body());
                    Log.d("MainActivity", list.toString());
                    ArrayAdapter<Location> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sp_item, list);
                    Log.d("MainActivity", adapter.toString());
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.locationSp.setAdapter(adapter);
                } else {
                    Log.e("Supabase", "Failed to fetch locations: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                Log.e("Supabase", "Error: " + t.getMessage(), t);
            }
        });

    }

    private void banners(ArrayList<SliderItems> items) {
        binding.viewPagerSlider.setAdapter(new SliderAdapter(items, binding.viewPagerSlider));
        binding.viewPagerSlider.setClipToPadding(false);
        binding.viewPagerSlider.setClipChildren(false);
        binding.viewPagerSlider.setOffscreenPageLimit(3);
        binding.viewPagerSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        binding.viewPagerSlider.setPageTransformer(compositePageTransformer);
    }

    private void initBanner() {
        binding.progressBarBanner.setVisibility(View.VISIBLE);

        BannerAPI bannerAPI = SupabaseClient.getInstance().create(BannerAPI.class);

        bannerAPI.getBanners().enqueue(new Callback<List<SliderItems>>() {
            @Override
            public void onResponse(@NonNull Call<List<SliderItems>> call, @NonNull Response<List<SliderItems>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<SliderItems> items = new ArrayList<>(response.body());
                    banners(items);
                    Log.d("MainActivity", "Banners loaded successfully: " + items.size());
                } else {
                    Log.e("MainActivity", "Failed to load banners: " + response.message());
                }
                binding.progressBarBanner.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<SliderItems>> call, @NonNull Throwable t) {
                Log.e("MainActivity", "Error: " + t.getMessage(), t);
                binding.progressBarBanner.setVisibility(View.GONE);
            }
        });
    }

    private void initCategory() {
        binding.progressBarCategory.setVisibility(View.VISIBLE);

        CategoryAPI categoryAPI = SupabaseClient.getInstance().create(CategoryAPI.class);

        categoryAPI.getCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(@NonNull Call<List<Category>> call, @NonNull Response<List<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Category> items = new ArrayList<>(response.body());
                    Log.d("MainActivity", "Categories loaded successfully: " + items.size());
                    if (!items.isEmpty()) {
                        binding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                                LinearLayoutManager.HORIZONTAL, false));
                        RecyclerView.Adapter adapter = new CategoryAdapter(items);
                        binding.recyclerViewCategory.setAdapter(adapter);

                    }
                    binding.progressBarCategory.setVisibility(View.GONE);

                } else {
                    Log.e("MainActivity", "Failed to load categories: " + response.message());
                }
                binding.progressBarBanner.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<Category>> call, @NonNull Throwable t) {

            }
        });
    }

    private void initRecommended() {
        binding.progressBarRecommended.setVisibility(View.VISIBLE);

        RecommendedItemAPI recommendedItemAPI = SupabaseClient.getInstance().create(RecommendedItemAPI.class);

        recommendedItemAPI.getRecommendedItems().enqueue(new Callback<List<ItemDomain>>() {

            @Override
            public void onResponse(@NonNull Call<List<ItemDomain>> call, @NonNull Response<List<ItemDomain>> response) {
                ArrayList<ItemDomain> items = new ArrayList<>(response.body());
                Log.d("MainActivity", "Recommended Items loaded successfully: " + items.size());

                if (!items.isEmpty()) {
                    binding.recyclerViewRecommended.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.HORIZONTAL, false));
                    RecyclerView.Adapter adapter = new RecommendedAdapter(items);
                    binding.recyclerViewRecommended.setAdapter(adapter);
                }
                binding.progressBarRecommended.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<ItemDomain>> call, @NonNull Throwable t) {

            }
        });

    }

    private void initPopular() {
        binding.progressBarPopular.setVisibility(View.VISIBLE);

        PopularItemsAPI recommendedItemAPI = SupabaseClient.getInstance().create(PopularItemsAPI.class);

        recommendedItemAPI.getPopularItems().enqueue(new Callback<List<ItemDomain>>() {

            @Override
            public void onResponse(@NonNull Call<List<ItemDomain>> call, @NonNull Response<List<ItemDomain>> response) {
                ArrayList<ItemDomain> items = new ArrayList<>(response.body());
                Log.d("MainActivity", "Popular Items loaded successfully: " + items.size());

                if (!items.isEmpty()) {
                    binding.recyclerViewPopular.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.HORIZONTAL, false));
                    RecyclerView.Adapter adapter = new PopularAdapter(items);
                    binding.recyclerViewPopular.setAdapter(adapter);
                }
                binding.progressBarPopular.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<ItemDomain>> call, @NonNull Throwable t) {

            }
        });

    }

}