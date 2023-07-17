package com.example.perfume;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.perfume.databinding.ActivityDetailedBinding;

public class DetailedActivity5 extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            int ingredients = intent.getIntExtra("ingredients", R.string.wonderIngredients);
            int desc = intent.getIntExtra("desc", R.string.wonderDesc);
            int image = intent.getIntExtra("image", R.drawable.wonder);

            binding.detailName.setText(name);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
    }
}
