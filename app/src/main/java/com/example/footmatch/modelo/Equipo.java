package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Equipo implements Parcelable {
    private String nombre;

    private String urlImagenEscudo;
    private int puntos;

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
