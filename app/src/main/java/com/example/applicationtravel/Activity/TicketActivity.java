package com.example.applicationtravel.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.applicationtravel.Domain.ItemDomain;
import com.example.applicationtravel.databinding.ActivityTicketBinding;

public class TicketActivity extends BaseActivity {
    private ActivityTicketBinding binding;
    private ItemDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        Glide.with(TicketActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        Glide.with(TicketActivity.this)
                .load(object.getTourguidepic())
                .into(binding.profile);

        binding.backBtn.setOnClickListener(v -> finish());
        binding.titleTxt.setText(object.getTitle());
        binding.durationTxt.setText(object.getDuration());
        binding.tourGuideTxt.setText(object.getDatetour());
        binding.timeTxt.setText(object.getTimetour());
        binding.tourGuideNameTxt.setText(object.getTourguidename());

        binding.callBtn.setOnClickListener(v -> {
            String phoneNumber = "88005553535";
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        });

        binding.messageBtn.setOnClickListener(v -> {
            String telegramChannelUrl = "https://t.me/PerspectiveViewz";

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(telegramChannelUrl));
            startActivity(browserIntent);
        });

    }

    private void getIntentExtra() {
        object = (ItemDomain) getIntent().getSerializableExtra("object");


    }
}