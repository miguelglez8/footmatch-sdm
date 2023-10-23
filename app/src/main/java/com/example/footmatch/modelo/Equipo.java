package com.example.footmatch.modelo;

public class Equipo {
    private String nombre;

    private String urlImagenEscudo;
    private int puntos;

    public Equipo(String nombre, String urlImagen, int puntos){
        this.nombre = nombre;
        this.urlImagenEscudo = urlImagen;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagenEscudo() {
        return urlImagenEscudo;
    }
}
