package com.example.renanalves.listviewcustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewItem  extends ArrayAdapter<Item> {

    private Context contexto;
    private ArrayList<Item> itens;

    public ListViewItem(Context context, ArrayList<Item> lista) {
        super(context,0,lista);
        this.contexto = context;
        this.itens = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item itemTemp = this.itens.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item,null);

        ImageView img = convertView.findViewById(R.id.imageView);
        TextView txt = convertView.findViewById(R.id.textView);

        img.setImageResource(itemTemp.getImg());
        txt.setText(itemTemp.getName());


        return convertView;
    }
}
