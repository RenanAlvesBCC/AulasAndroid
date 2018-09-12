package com.combustivel.renan.appcombustivel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    Button btnConsumo;
    Button btnCombustivel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConsumo = findViewById(R.id.btnConsumo);
        btnCombustivel = findViewById(R.id.btnCombustivel);

        btnConsumo.setOnClickListener(this);
        btnCombustivel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnCombustivel:
                intent = new Intent(this,CombustivelActivity.class);
                startActivity(intent);
                break;
            case R.id.btnConsumo:
                intent = new Intent(this,AutonomiaActivity.class);
                startActivity(intent);
                break;
        }

    }
}
