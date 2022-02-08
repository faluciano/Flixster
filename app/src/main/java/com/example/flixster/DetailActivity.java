package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvDetailTitle);
        tvOverview = findViewById(R.id.tvDetailOverview);
        ratingBar = findViewById(R.id.ratingBar);

        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
    }
}