package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Estadisticas implements Parcelable {
    private int victorias;
    private int empates;
    private int derrotas;

    // Constructor
    public Estadisticas(int victorias, int empates, int derrotas) {
        this.victorias = victorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    protected Estadisticas(Parcel in) {
        victorias = in.readInt();
        empates = in.readInt();
        derrotas = in.readInt();
    }

    public static final Creator<Estadisticas> CREATOR = new Creator<Estadisticas>() {
        @Override
        public Estadisticas createFromParcel(Parcel in) {
            return new Estadisticas(in);
        }

        @Override
        public Estadisticas[] newArray(int size) {
            return new Estadisticas[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(victorias);
        parcel.writeInt(empates);
        parcel.writeInt(derrotas);
    }
}

