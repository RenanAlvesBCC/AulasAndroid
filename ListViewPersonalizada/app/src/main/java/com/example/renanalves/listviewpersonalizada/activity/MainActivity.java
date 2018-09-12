package com.example.renanalves.listviewpersonalizada.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.renanalves.listviewpersonalizada.R;

public class MainActivity extends Activity {

    ListView carros;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.arrayCarros));
        carros = findViewById(R.id.listView);

        carros.setAdapter(adapter);
    }
}
