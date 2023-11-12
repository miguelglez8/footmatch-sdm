package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Equipo implements Parcelable {
    private String nombre;
    private List<Jugador> plantillaTitular;
    private String formacion;

    public List<Jugador> getPlantillaTitular() {
        return plantillaTitular;
    }

    public void setPlantillaTitular(List<Jugador> plantillaTitular) {
        this.plantillaTitular = plantillaTitular;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    private Estadisticas estadisticas;

    protected Equipo(Parcel in) {
        nombre = in.readString();
        formacion = in.readString();
        urlImagenEscudo = in.readString();
        puntos = in.readInt();
        entrenador = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(formacion);
        dest.writeString(urlImagenEscudo);
        dest.writeInt(puntos);
        dest.writeString(entrenador);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Equipo> CREATOR = new Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel in) {
            return new Equipo(in);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantillaTitular = plantilla;
    }

    public void setUrlImagenEscudo(String urlImagenEscudo) {
        this.urlImagenEscudo = urlImagenEscudo;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    private String urlImagenEscudo;
    private int puntos;
    private String entrenador;

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

    public int getPuntos(){return puntos; }
}
