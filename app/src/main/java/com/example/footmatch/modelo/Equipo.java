package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Equipo implements Parcelable {
    private String nombre;
    private List<Jugador> plantillaTitular;
    private String formacion;
    private String urlImagenEscudo;
    private int puntos;
    private String entrenador;

    public Equipo(String nombre, String urlImagenEscudo, int puntos) {
        this.nombre = nombre;
        this.plantillaTitular = plantillaTitular;
        this.formacion = formacion;
        this.urlImagenEscudo = urlImagenEscudo;
        this.puntos = puntos;
        this.entrenador = entrenador;
    }

    protected Equipo(Parcel in) {
        nombre = in.readString();
        plantillaTitular = in.createTypedArrayList(Jugador.CREATOR);
        formacion = in.readString();
        urlImagenEscudo = in.readString();
        puntos = in.readInt();
        entrenador = in.readString();
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

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagenEscudo() {
        return urlImagenEscudo;
    }

    public int getPuntos(){return puntos; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeTypedList(plantillaTitular);
        parcel.writeString(formacion);
        parcel.writeString(urlImagenEscudo);
        parcel.writeInt(puntos);
        parcel.writeString(entrenador);
    }
}
