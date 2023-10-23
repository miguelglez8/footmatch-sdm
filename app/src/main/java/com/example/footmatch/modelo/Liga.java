package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Liga implements Parcelable {

    public List<Equipo> equipos;

    public String name;

    public Liga(List<Equipo> equipos, String name){
        this.name = name;
        this.equipos = equipos;
    }

    protected Liga(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Liga> CREATOR = new Creator<Liga>() {
        @Override
        public Liga createFromParcel(Parcel in) {
            return new Liga(in);
        }

        @Override
        public Liga[] newArray(int size) {
            return new Liga[size];
        }
    };

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
