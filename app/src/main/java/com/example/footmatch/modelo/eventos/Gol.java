package com.example.footmatch.modelo.eventos;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.R;

public class Gol extends Evento implements Parcelable {
    private String jugadorGol;
    private String jugadorAsistencia;
    private String urlGol, urlAsistencia;

    public Gol(String jugadorGol, String jugadorAsistencia, int minute, boolean local) {
        super.minuto = minute;
        super.local = local;
        this.jugadorGol = jugadorGol;
        this.jugadorAsistencia = jugadorAsistencia;
    }

    protected Gol(Parcel in) {
        jugadorGol = in.readString();
        jugadorAsistencia = in.readString();
        urlGol = in.readString();
        urlAsistencia = in.readString();
        super.minuto = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            super.local = in.readInt() == 1;
        }
    }

    public static final Creator<Gol> CREATOR = new Creator<Gol>() {
        @Override
        public Gol createFromParcel(Parcel in) {
            return new Gol(in);
        }

        @Override
        public Gol[] newArray(int size) {
            return new Gol[size];
        }
    };

    @Override
    public String getPrimerFactor() {
        return jugadorGol;
    }

    @Override
    public String getSegundoFactor() {
        return jugadorAsistencia;
    }

    @Override
    public int getPrimerUrl() {
        return R.drawable.icono_balonde_futbol;
    }

    @Override
    public int getSegundoUrl() {
        return R.drawable.icono_bota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(jugadorGol);
        parcel.writeString(jugadorAsistencia);
        parcel.writeString(urlGol);
        parcel.writeString(urlAsistencia);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeInt(super.local ? 1 : 0);
        }
        parcel.writeInt(super.minuto);
    }
}
