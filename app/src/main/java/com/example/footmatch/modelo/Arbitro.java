package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Arbitro implements Parcelable {
    private String nombre;
    private String cargo;

    public Arbitro(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    protected Arbitro(Parcel in) {
        nombre = in.readString();
        cargo = in.readString();
    }

    public static final Creator<Arbitro> CREATOR = new Creator<Arbitro>() {
        @Override
        public Arbitro createFromParcel(Parcel in) {
            return new Arbitro(in);
        }

        @Override
        public Arbitro[] newArray(int size) {
            return new Arbitro[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(cargo);
    }
}
