package com.example.renanalves.passagemparametro;

import java.io.Serializable;

public class Carro implements Serializable{

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

    private String fabricante;
    private String modelo;
}
