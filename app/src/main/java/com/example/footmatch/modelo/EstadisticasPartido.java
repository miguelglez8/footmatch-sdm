package com.example.footmatch.modelo;

public class EstadisticasPartido {
    private String estadistica;
    private String valorEstadistica;

    public EstadisticasPartido(String estadistica, String valorEstadistica) {
        this.estadistica = estadistica;
        this.valorEstadistica = valorEstadistica;
    }

    public String getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(String estadistica) {
        this.estadistica = estadistica;
    }

    public String getValorEstadistica() {
        return valorEstadistica;
    }

    public void setValorEstadistica(String valorEstadistica) {
        this.valorEstadistica = valorEstadistica;
    }
}
