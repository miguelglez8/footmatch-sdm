package com.example.footmatch.modelo;

public class Jugador {
    private int dorsal;
    private String posicion;
    private String nombre;

    public Jugador(int dorsal, String posicion, String nombre) {
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
