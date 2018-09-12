package com.example.renanalves.listviewpersonalizada.model;

import android.widget.ImageView;

public class Carro {

    private String fabricante;
    private String modelo;
    private ImageView imagem;



    public Carro(String modelo, String fabricante, ImageView imgLogo) {
        this.setFabricante(fabricante);
        this.setModelo(modelo);
        this.setImagem(imgLogo);
    }


    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }



}
