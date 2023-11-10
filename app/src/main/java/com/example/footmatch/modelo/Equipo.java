package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Equipo implements Parcelable {
    private String nombre;
    private List<Jugador> plantillaTitular;
    private String formacion;

    private Estadisticas estadisticas;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getPlantilla() {
        return plantillaTitular;
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

    protected Equipo(Parcel in) {
        nombre = in.readString();
        urlImagenEscudo = in.readString();
        puntos = in.readInt();
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
        parcel.writeString(urlImagenEscudo);
        parcel.writeInt(puntos);
    }
}
