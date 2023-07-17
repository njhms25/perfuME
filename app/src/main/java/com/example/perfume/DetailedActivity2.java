package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.perfume.databinding.ActivityDetailedBinding;

public class DetailedActivity2 extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            int ingredients = intent.getIntExtra("ingredients", R.string.frostedIngredients);
            int desc = intent.getIntExtra("desc", R.string.frostedDesc);
            int image = intent.getIntExtra("image", R.drawable.frosted);

            binding.detailName.setText(name);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
    }
}
