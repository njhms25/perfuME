package com.example.perfume;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ItemActivity5 extends AppCompatActivity {

    ListAdapter5 listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item5);

        int[] imageList = {R.drawable.sweet, R.drawable.wonder, R.drawable.marshmallow};
        int[] ingredientList = {R.string.sweetIngredients, R.string.wonderIngredients, R.string.marshmallowIngredients};
        int[] descList = {R.string.sweetDesc, R.string.wonderDesc, R.string.marshmallowDesc};

        String[] nameList = {"Sweet Honesty Everlasting", "Wonder Rose Summer", "Marshmallow Addiction"};

        listView = findViewById(R.id.listView5);

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], ingredientList[i], descList[i], imageList[i], R.layout.list_item5);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter5(ItemActivity5.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ItemActivity5.this, DetailedActivity5.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
