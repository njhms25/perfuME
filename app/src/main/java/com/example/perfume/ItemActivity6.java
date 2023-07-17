package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ItemActivity6 extends AppCompatActivity {

    ListAdapter6 listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item6);

        int[] imageList = {R.drawable.vanille, R.drawable.brown, R.drawable.bombshell};
        int[] ingredientList = {R.string.vanilleIngredients, R.string.brownIngredients, R.string.bombshellIngredients};
        int[] descList = {R.string.vanilleDesc, R.string.brownDesc, R.string.bombshellDesc};

        String[] nameList = {"Vanille Antique", "Brownmakers", "Bombshell Nights"};

        listView = findViewById(R.id.listView6);

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], ingredientList[i], descList[i], imageList[i], R.layout.list_item6);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter6(ItemActivity6.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ItemActivity6.this, DetailedActivity6.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
