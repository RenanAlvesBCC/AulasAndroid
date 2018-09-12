package com.example.renanalves.listviewpersonalizada.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.renanalves.listviewpersonalizada.R;
import com.example.renanalves.listviewpersonalizada.model.Carro;

import java.util.List;

public class AdapterCarro  extends BaseAdapter{

    private Activity activity;
    private List<Carro> carros;


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    //------------------------------------------------------

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Carro carro = carros.get(i);

        View vCarro = LayoutInflater.from(this.activity).inflate(R.layout.layoul_carro_list,null);

        TextView fabricante = vCarro.findViewById(R.id.fabricante);
        TextView modelo = vCarro.findViewById(R.id.modelo);
        ImageView imgLogo = vCarro.findViewById(R.id.imgLogo);

        fabricante.setText(carro.getFabricante());
        modelo.setText(carro.getModelo());
        imgLogo.setImageResource(carro.getImagem());

        return vCarro;
    }
}
