package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Jugador implements Parcelable {
    private int dorsal;
    private String posicion;
    private String nombre;

    public Jugador(int dorsal, String posicion, String nombre) {
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nombre = nombre;
    }

    protected Jugador(Parcel in) {
        dorsal = in.readInt();
        posicion = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Jugador> CREATOR = new Creator<Jugador>() {
        @Override
        public Jugador createFromParcel(Parcel in) {
            return new Jugador(in);
        }

        @Override
        public Jugador[] newArray(int size) {
            return new Jugador[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(dorsal);
        parcel.writeString(posicion);
        parcel.writeString(nombre);
    }
}
