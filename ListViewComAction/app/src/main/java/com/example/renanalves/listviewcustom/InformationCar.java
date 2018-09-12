package com.example.renanalves.listviewcustom;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InformationCar extends Activity {

    ImageView img;
    TextView txt;
    TextView txtFabricante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_car);



        img = findViewById(R.id.imgCar);
        txt = findViewById(R.id.txtNameCar);
        txtFabricante = findViewById(R.id.lblFabricante);

        Item itemSelected = (Item) getIntent().getSerializableExtra("Item");

        img.setImageResource(itemSelected.getImg());
        txt.setText(itemSelected.getName());
        txtFabricante.setText(itemSelected.getFabricante());
    }
}
