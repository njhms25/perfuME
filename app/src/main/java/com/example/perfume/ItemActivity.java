package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        int[] imageList = {R.drawable.sunwashedcitrus, R.drawable.citruschill, R.drawable.enchauntercharming};
        int[] ingredientList = {R.string.sunIngredients, R.string.citrusIngredients, R.string.enchaunterIngredients};
        int[] descList = {R.string.sunDesc, R.string.citrusDesc, R.string.enchaunterDesc};

        String[] nameList = {"Sun Washed Citrus", "Citrus Chill", "Enchanter Chill"};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], ingredientList[i], descList[i], imageList[i], R.layout.list_item2);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(ItemActivity.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ItemActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
