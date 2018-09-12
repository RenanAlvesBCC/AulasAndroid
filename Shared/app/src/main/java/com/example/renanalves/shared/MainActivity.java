package com.example.renanalves.shared;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText name;
    EditText user;
    EditText email;
    EditText tel;
    Button btnShared;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.EtdTxtName);
        user = findViewById(R.id.EtdTxtUser);
        email = findViewById(R.id.EtdTxtEmail);
        tel = findViewById(R.id.EtdTxtTel);

        btnShared = findViewById(R.id.shared);
        btnShared.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.shared) {
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,user.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,name.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,email.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,tel.getText().toString());
            intent.setType("text/plain");
            startActivity(intent);
        }

    }
}
