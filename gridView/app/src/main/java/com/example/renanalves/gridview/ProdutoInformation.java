package com.example.renanalves.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdutoInformation extends Activity {

    ImageView img;
    TextView name;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato_information);

        Produto produto = (Produto) getIntent().getSerializableExtra("Produto");

        img = findViewById(R.id.imgContato);
        name = findViewById(R.id.nameContato);
        description = findViewById(R.id.descContato);

        img.setImageResource(produto.getImage());
        name.setText(produto.getName());
        description.setText(produto.getDescription());
    }
}
