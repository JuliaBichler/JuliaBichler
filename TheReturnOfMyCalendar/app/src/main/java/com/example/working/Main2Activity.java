package com.example.working;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.listView);
        ArrayList<String> event = (ArrayList<String>) getIntent().getSerializableExtra("event");
        ArrayList<String> date = (ArrayList<String>) getIntent().getSerializableExtra("date");
        //listView.addsetText(String.valueOf(events));

        ArrayAdapter<String> arrayAdapterE = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, event );

        arrayAdapterE.addAll(event);

        /*for(int i=0; i< event.size();i++){
            arrayAdapter.add(event.get(i));
        }*/
        listView.setAdapter(arrayAdapterE);


/*
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, date );

        listView.setAdapter(arrayAdapter);*/
    }
}