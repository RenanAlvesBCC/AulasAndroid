package com.combustivel.renan.appcombustivel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AutonomiaActivity extends Activity implements View.OnClickListener{

    EditText sQuilometros;
    EditText sLitros;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomia);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        sQuilometros = findViewById(R.id.edtTextKm);
        sLitros = findViewById(R.id.edtTextLitros);

        Double vQuilometros = Double.parseDouble(sQuilometros.getText().toString());
        Double vLitros = Double.parseDouble(sLitros.getText().toString());
        Double resultado = vQuilometros/vLitros;


        switch (view.getId()) {
            case R.id.btnCalcular:
                Toast.makeText(this,"Media de:"++"KM por litros",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
