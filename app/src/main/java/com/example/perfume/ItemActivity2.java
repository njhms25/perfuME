package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ItemActivity2 extends AppCompatActivity {

    ListAdapter2 listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item2);

        int[] imageList = {R.drawable.frosted, R.drawable.sleigh, R.drawable.balsam};
        int[] ingredientList = {R.string.frostedIngredients, R.string.sleighIngredients, R.string.balsamIngredients};
        int[] descList = {R.string.frostedDesc, R.string.sleighDesc, R.string.balsamDesc};

        String[] nameList = {"Frosted Winter Woods", "Sleigh Rides & Snuggles", "Balsam Perfume"};

        listView = findViewById(R.id.listView2);

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], ingredientList[i], descList[i], imageList[i], R.layout.list_item2);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter2(ItemActivity2.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ItemActivity2.this, DetailedActivity2.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
