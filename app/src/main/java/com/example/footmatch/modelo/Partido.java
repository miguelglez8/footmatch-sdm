package com.example.footmatch.modelo;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.modelo.eventos.Evento;

import java.util.List;

public class Partido implements Parcelable {

    public String getUrlLiga() {
        return urlLiga;
    }

    public void setUrlLiga(String urlLiga) {
        this.urlLiga = urlLiga;
    }

    public String getMinutoJuego() {
        return minutoJuego;
    }

    public void setMinutoJuego(String minutoJuego) {
        this.minutoJuego = minutoJuego;
    }

    public List<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(List<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String resultado;
    private String fechaPartido; // Formato utc
    private String estadoPartido;
    private String liga;
    private String urlLiga;
    private String jornada;
    private String estadio;
    private EstadisticasPartido estadisticasPartido;
    private String hora; // 18:45
    private String minutoJuego; // "" si no se jugó, "34'" si está en el 34 y "90'" si ya se jugó
    private List<Arbitro> arbitros;
    private List<Evento> eventos; // gol, cambio, lesión o tarjeta (tienen que ir en orden)

    protected Partido(Parcel in) {
        equipoLocal = in.readParcelable(Equipo.class.getClassLoader());
        equipoVisitante = in.readParcelable(Equipo.class.getClassLoader());
        resultado = in.readString();
        fechaPartido = in.readString();
        estadoPartido = in.readString();
        liga = in.readString();
        urlLiga = in.readString();
        jornada = in.readString();
        estadio = in.readString();
        hora = in.readString();
        minutoJuego = in.readString();
        arbitros = in.createTypedArrayList(Arbitro.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(equipoLocal, flags);
        dest.writeParcelable(equipoVisitante, flags);
        dest.writeString(resultado);
        dest.writeString(fechaPartido);
        dest.writeString(estadoPartido);
        dest.writeString(liga);
        dest.writeString(urlLiga);
        dest.writeString(jornada);
        dest.writeString(estadio);
        dest.writeString(hora);
        dest.writeString(minutoJuego);
        dest.writeTypedList(arbitros);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Partido> CREATOR = new Creator<Partido>() {
        @Override
        public Partido createFromParcel(Parcel in) {
            return new Partido(in);
        }

        @Override
        public Partido[] newArray(int size) {
            return new Partido[size];
        }
    };

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getEstadoPartido() {
        return estadoPartido;
    }

    public void setEstadoPartido(String estadoPartido) {
        this.estadoPartido = estadoPartido;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public EstadisticasPartido getEstadisticasPartido() {
        return estadisticasPartido;
    }

    public void setEstadisticasPartido(EstadisticasPartido estadisticasPartido) {
        this.estadisticasPartido = estadisticasPartido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

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

    public String getNombreLiga() {
        return liga;
    }

    public String getEstadio() {
        return estadio;
    }

}
