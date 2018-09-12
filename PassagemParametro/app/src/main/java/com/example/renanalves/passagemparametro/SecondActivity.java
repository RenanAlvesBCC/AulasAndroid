package com.example.renanalves.passagemparametro;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Carro carro = (Carro) getIntent().getSerializableExtra("objCarro");
    }
}
