package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ItemActivity3 extends AppCompatActivity {

    ListAdapter3 listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);

        int[] imageList = {R.drawable.fbomb, R.drawable.cfloral, R.drawable.fbruby};
        int[] ingredientList = {R.string.fbombIngredients, R.string.cfloralIngredients, R.string.fbRubyIngredients};
        int[] descList = {R.string.fbombDesc, R.string.cfloralDesc, R.string.fbRubyDesc};

        String[] nameList = {"Flowerbomb", "Coach Floral Blush", "Flowerbomb Ruby Orchid"};

        listView = findViewById(R.id.listView3);

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], ingredientList[i], descList[i], imageList[i], R.layout.list_item3);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter3(ItemActivity3.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ItemActivity3.this, DetailedActivity3.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
