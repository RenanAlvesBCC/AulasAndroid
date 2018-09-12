package com.example.renanalves.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomGrid extends BaseAdapter{

    private Context context;
    private List<Produto> produtos = new ArrayList<Produto>();

    public CustomGrid(Context context,List<Produto> contatos) {
        this.context = context;
        this.produtos = contatos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int i) {
        return produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View grid = LayoutInflater.from(this.context).inflate(R.layout.grid_single,null);

        TextView name = grid.findViewById(R.id.nameContato);
        ImageView imgView = grid.findViewById(R.id.imgContato);
        imgView.setImageResource(this.produtos.get(i).getImage());

        return grid;
    }
}
