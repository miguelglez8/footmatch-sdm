package com.example.footmatch.modelo.eventos;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.R;

public class Tarjeta extends Evento implements Parcelable {
    private String jugadorTarjeta;
    private String urlTarjeta;
    private Color color;
    public Tarjeta(String jugadorTarjeta, int minute, boolean local, Color color) {
        super.minuto = minute;
        super.local = local;
        this.jugadorTarjeta = jugadorTarjeta;
        this.color = color;
    }

    protected Tarjeta(Parcel in) {
        jugadorTarjeta = in.readString();
        urlTarjeta = in.readString();
        super.minuto = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            super.local = in.readInt() == 1;
        }
    }

    public static final Creator<Tarjeta> CREATOR = new Creator<Tarjeta>() {
        @Override
        public Tarjeta createFromParcel(Parcel in) {
            return new Tarjeta(in);
        }

        @Override
        public Tarjeta[] newArray(int size) {
            return new Tarjeta[size];
        }
    };

    @Override
    public String getPrimerFactor() {
        return jugadorTarjeta;
    }

    @Override
    public String getSegundoFactor() {
        return "";
    }

    @Override
    public int getPrimerUrl() {
        return color.equals(Color.AMARILLA) ? R.drawable.icono_tarjeta_amarilla : R.drawable.icono_tarjeta_roja;
    }

    @Override
    public int getSegundoUrl() {
        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(jugadorTarjeta);
        parcel.writeString(urlTarjeta);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeInt(super.local ? 1 : 0);
        }
        parcel.writeInt(super.minuto);
    }
}
