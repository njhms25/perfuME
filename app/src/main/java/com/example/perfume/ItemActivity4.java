package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ItemActivity4 extends AppCompatActivity {

    ListAdapter4 listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item4);

        int[] imageList = {R.drawable.kiss, R.drawable.guilty, R.drawable.viride};
        int[] ingredientList = {R.string.kissIngredients, R.string.guiltyIngredients, R.string.viridieIngredients};
        int[] descList = {R.string.kissDesc, R.string.guiltyDesc, R.string.viridieDesc};

        String[] nameList = {"A Kiss From a Rose", "Gucci Guilty Black Pour Homme", "Viride By Orto"};

        listView = findViewById(R.id.listView4);

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], ingredientList[i], descList[i], imageList[i], R.layout.list_item4);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter4(ItemActivity4.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ItemActivity4.this, DetailedActivity4.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
