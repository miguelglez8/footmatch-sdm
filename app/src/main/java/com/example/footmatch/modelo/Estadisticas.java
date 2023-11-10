package com.example.footmatch.modelo;

public class Estadisticas {
    private int victorias;
    private int empates;
    private int derrotas;

    // Constructor
    public Estadisticas(int victorias, int empates, int derrotas) {
        this.victorias = victorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    // Getter y Setter para victorias
    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    // Getter y Setter para empates
    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    // Getter y Setter para derrotas
    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}

