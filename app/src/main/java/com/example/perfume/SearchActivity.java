package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SearchActivity extends AppCompatActivity {

    private CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initialize the CardViews
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);

        // Set click listeners for each card
        card1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Handle click for card1
                Intent intent = new Intent(SearchActivity.this, ItemActivity2.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for card1
                Intent intent = new Intent(SearchActivity.this, ItemActivity.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for card1
                Intent intent = new Intent(SearchActivity.this, ItemActivity6.class);
                startActivity(intent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for card1
                Intent intent = new Intent(SearchActivity.this, ItemActivity3.class);
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for card1
                Intent intent = new Intent(SearchActivity.this, ItemActivity4.class);
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for card1
                Intent intent = new Intent(SearchActivity.this, ItemActivity5.class);
                startActivity(intent);
            }
        });

    }
}
