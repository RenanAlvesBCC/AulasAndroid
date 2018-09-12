package com.example.renanalves.gridviewcalledotherapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridViewCustom extends BaseAdapter {

    ArrayList<Application> applications = new ArrayList<Application>();
    Context context;

    public GridViewCustom(ArrayList<Application> _applications, Context _context) {
        applications= _applications;
        context = _context;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @Override
    public Object getItem(int i) {
        return applications.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid = LayoutInflater.from(this.context).inflate(R.layout.activity_grid_view_custom,null);

        ImageView img = grid.findViewById(R.id.img);
        img.setImageResource(applications.get(i).getImg());

        return grid;
    }
}
