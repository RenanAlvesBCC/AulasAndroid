package com.example.renanalves.listviewcustom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> itens = new ArrayList<Item>();

        Item itemA = new Item(R.drawable.gol, "Gol","VolksWagem");
        Item itemB = new Item(R.drawable.palio, "Palio","Fiat");
        Item itemC = new Item(R.drawable.uno2, "Uno","Fiat");

        itens.add(itemA);
        itens.add(itemB);
        itens.add(itemC);

        ListViewItem lista = new ListViewItem(this,itens);

        ListView lView = findViewById(R.id.carList);

        lView.setAdapter(lista);

        final Intent intent;
        intent = new Intent(this, InformationCar.class);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = (Item) adapterView.getAdapter().getItem(i);
                intent.putExtra("Item",  item);

                startActivity(intent);
            }
        });
    }
}
