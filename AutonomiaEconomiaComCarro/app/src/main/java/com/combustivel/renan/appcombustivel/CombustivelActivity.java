package com.combustivel.renan.appcombustivel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CombustivelActivity extends Activity implements View.OnClickListener{

    EditText sGasolina;
    EditText sAlcool;
    Button btnCalcular;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnCalcular.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        sGasolina = findViewById(R.id.edtTextGasolina);
        sAlcool = findViewById(R.id.edtTextAlcool);
        Double vGasolina = Double.parseDouble(sGasolina.getText().toString());
        Double vAlcool = Double.parseDouble(sAlcool.getText().toString());

        switch (view.getId()){
            case R.id.btnCalcular:
                if(vAlcool/vGasolina < 0.7) {
                    Toast.makeText(this,"Utilize Alcool",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this,"Utilize Alcool.",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnCancelar:

                break;
        }

    }
}
