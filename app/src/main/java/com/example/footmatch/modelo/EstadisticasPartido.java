package com.example.footmatch.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class EstadisticasPartido implements Parcelable {
    private List<String> estadisticas;

    public EstadisticasPartido(List<String> estadisticas) {
        this.estadisticas = estadisticas;
    }

    protected EstadisticasPartido(Parcel in) {
        estadisticas = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(estadisticas);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EstadisticasPartido> CREATOR = new Creator<EstadisticasPartido>() {
        @Override
        public EstadisticasPartido createFromParcel(Parcel in) {
            return new EstadisticasPartido(in);
        }

        @Override
        public EstadisticasPartido[] newArray(int size) {
            return new EstadisticasPartido[size];
        }
    };

    public List<String> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<String> estadisticas) {
        this.estadisticas = estadisticas;
    }
}
