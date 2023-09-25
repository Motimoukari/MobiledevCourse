package com.example.mobiledevcourse;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    static String[] vehicles;
    static String[] powers;
    static String[] weights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        vehicles = res.getStringArray(R.array.vehicles);
        powers = res.getStringArray(R.array.powers);
        weights = res.getStringArray(R.array.weights);

        ItemAdapter itemAdapter = new ItemAdapter(this, vehicles, powers, weights);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.mobiledevcourse.ITEM_INDEX", i);
                //Log.d("asd", Integer.toString(i));
                startActivity(showDetailActivity);
            }
        });


       // myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items));



    }
}