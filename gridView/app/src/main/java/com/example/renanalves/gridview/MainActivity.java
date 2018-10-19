package com.example.renanalves.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    GridView grid;
    List<Produto> produtos = new ArrayList<Produto>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Produto produto = new Produto("Gol", R.drawable.gol,"Modelo 1.0 0km.");
        produtos.add(produto);
        produto = new Produto("Uno", R.drawable.uno2,"Modelo 1.0 10 mil km.");
        produtos.add(produto);
        produto = new Produto("Palio", R.drawable.palio,"Modelo 1.0 20 mil km.");
        produtos.add(produto);
        produto = new Produto("Gol2", R.drawable.gol,"Modelo 1.6 65 mil km.");
        produtos.add(produto);
        produto = new Produto("Uno2", R.drawable.uno2,"Modelo 1.4 30 mil km.");
        produtos.add(produto);
        produto = new Produto("Palio2", R.drawable.palio,"Modelo 1.4 45 mil km.");
        produtos.add(produto);

        grid = findViewById(R.id.gridView);
        final CustomGrid adapter = new CustomGrid(this, produtos);

        grid.setAdapter(adapter);

        final Intent intent = new Intent(this,ProdutoInformation.class);

//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Produto contato = (Produto) adapterView.getAdapter().getItem(i);
//
//                intent.putExtra("Produto",contato);
//                startActivity(intent);
//            }
//        });
    }

}
