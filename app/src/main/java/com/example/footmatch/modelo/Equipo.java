package com.example.footmatch.modelo;

public class Equipo {
    private String nombre;

    private String urlImagenEscudo;

    public Equipo(String nombre, String urlImagen){
        this.nombre = nombre;
        this.urlImagenEscudo = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagenEscudo() {
        return urlImagenEscudo;
    }
}
