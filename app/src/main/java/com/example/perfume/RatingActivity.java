package com.example.perfume;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RatingActivity extends AppCompatActivity {

    Button submit, clear;
    DatabaseReference dbRating = FirebaseDatabase.getInstance().getReference().child("Rating");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitRating();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });
    }

    private void submitRating() {
        TextInputEditText nameInput = findViewById(R.id.name);
        TextInputEditText ratingInput = findViewById(R.id.rating);

        String name = nameInput.getText().toString().trim();
        String rating = ratingInput.getText().toString().trim();

        if (!name.isEmpty() && !rating.isEmpty()) {
            String ratingId = dbRating.push().getKey();
            dbRating.child(ratingId).child("Name").setValue(name);
            dbRating.child(ratingId).child("Rating").setValue(rating);

            Toast.makeText(getApplicationContext(), "Thank you for your rating!", Toast.LENGTH_SHORT).show();

            clearFields();
        } else {
            Toast.makeText(getApplicationContext(), "Please fill in all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        TextInputEditText nameInput = findViewById(R.id.name);
        TextInputEditText ratingInput = findViewById(R.id.rating);

        nameInput.getText().clear();
        ratingInput.getText().clear();
    }
}
