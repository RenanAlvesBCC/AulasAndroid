package com.example.renanalves.listviewcustom;

import java.io.Serializable;

public class Item implements Serializable{

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int img;
    private String name;

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String fabricante) {
        Fabricante = fabricante;
    }

    private String Fabricante;

    public Item(int img, String name, String fabricante) {

        this.setImg(img);
        this.setName(name);
        this.setFabricante(fabricante);
    }

}
