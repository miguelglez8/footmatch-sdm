package com.example.footmatch.modelo;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.modelo.eventos.Evento;

import java.util.List;

public class Partido implements Parcelable {

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
        estadisticasPartidoE1 = in.readParcelable(EstadisticasPartido.class.getClassLoader());
        estadisticasPartidoE2 = in.readParcelable(EstadisticasPartido.class.getClassLoader());
        estadisticasE1 = in.readParcelable(Estadisticas.class.getClassLoader());
        estadisticasE2 = in.readParcelable(Estadisticas.class.getClassLoader());
        hora = in.readString();
        minutoJuego = in.readString();
        arbitros = in.createTypedArrayList(Arbitro.CREATOR);
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
    private EstadisticasPartido estadisticasPartidoE1;
    private EstadisticasPartido estadisticasPartidoE2;
    private Estadisticas estadisticasE1;
    private Estadisticas estadisticasE2;

    public EstadisticasPartido getEstadisticasPartidoE1() {
        return estadisticasPartidoE1;
    }

    public void setEstadisticasPartidoE1(EstadisticasPartido estadisticasPartidoE1) {
        this.estadisticasPartidoE1 = estadisticasPartidoE1;
    }

    public EstadisticasPartido getEstadisticasPartidoE2() {
        return estadisticasPartidoE2;
    }

    public void setEstadisticasPartidoE2(EstadisticasPartido estadisticasPartidoE2) {
        this.estadisticasPartidoE2 = estadisticasPartidoE2;
    }

    public Estadisticas getEstadisticasE1() {
        return estadisticasE1;
    }

    public void setEstadisticasE1(Estadisticas estadisticasE1) {
        this.estadisticasE1 = estadisticasE1;
    }

    public Estadisticas getEstadisticasE2() {
        return estadisticasE2;
    }

    public void setEstadisticasE2(Estadisticas estadisticasE2) {
        this.estadisticasE2 = estadisticasE2;
    }
    private String hora; // 18:45
    private String minutoJuego; // "" si no se jugó, "34'" si está en el 34 y "90'" si ya se jugó
    private List<Arbitro> arbitros;
    private List<Evento> eventos; // gol, cambio, lesión o tarjeta (tienen que ir en orden)

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(equipoLocal, i);
        parcel.writeParcelable(equipoVisitante, i);
        parcel.writeString(resultado);
        parcel.writeString(fechaPartido);
        parcel.writeString(estadoPartido);
        parcel.writeString(liga);
        parcel.writeString(urlLiga);
        parcel.writeString(jornada);
        parcel.writeString(estadio);
        parcel.writeParcelable(estadisticasPartidoE1, i);
        parcel.writeParcelable(estadisticasPartidoE2, i);
        parcel.writeParcelable(estadisticasE1, i);
        parcel.writeParcelable(estadisticasE2, i);
        parcel.writeString(hora);
        parcel.writeString(minutoJuego);
        parcel.writeTypedList(arbitros);
    }
}
