package com.example.footmatch.modelo;



public class Partido {

    private Equipo equipoLocal;


    private Equipo equipoVisitante;


    private String resultado;


    private String fechaPartido; // Formato utc


    private String estadoPartido;

    public Partido(Equipo local, Equipo visitante, String resultado, String fechaUtc, String estado){
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.resultado = resultado;
        this.fechaPartido = fechaUtc;
        this.estadoPartido = estado;
    }

    public String getLocalTeamName() {
        return equipoLocal.getNombre();
    }

    public String getAwayTeamName() {
        return equipoVisitante.getNombre();
    }

    public String getResultado() {
        return resultado;
    }

    public String getEstado() {
        return estadoPartido;
    }

    public String getFecha() {
        return fechaPartido;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }



    



}
