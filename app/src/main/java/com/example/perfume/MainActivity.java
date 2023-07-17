package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    CardView cardSearch;
    CardView cardCamera;
    CardView cardMap;
    CardView cardRating;
    CardView cardAboutUs;
    CardView cardSetting;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Write data to Firebase
        writeDataToFirebase();

        cardSearch = findViewById(R.id.cardSearch);
        cardCamera = findViewById(R.id.cardCamera);
        cardMap = findViewById(R.id.cardMap);
        cardRating = findViewById(R.id.cardRating);
        cardAboutUs = findViewById(R.id.cardAboutUs);
        cardSetting = findViewById(R.id.cardSetting);

        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        cardCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerfumeDetectActivity.class);
                startActivity(intent);
            }
        });

        cardMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        cardRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intent);
            }
        });

        cardAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });



        cardSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void writeDataToFirebase() {
        // Example: Writing data to Firebase
        String message = "Hello, Firebase!";
        mDatabase.child("messages").setValue(message);
    }
}
