package com.example.footmatch.modelo.eventos;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.R;
import com.example.footmatch.modelo.Jugador;

public class Gol extends Evento implements Parcelable {
    private Jugador jugadorGol;
    private Jugador jugadorAsistencia;

    private String urlGol, urlAsistencia;

    protected Gol(Parcel in) {
        jugadorGol = in.readParcelable(Jugador.class.getClassLoader());
        jugadorAsistencia = in.readParcelable(Jugador.class.getClassLoader());
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
        return jugadorGol.getNombre();
    }

    @Override
    public String getSegundoFactor() {
        return jugadorAsistencia.getNombre();
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
        parcel.writeParcelable(jugadorGol, i);
        parcel.writeParcelable(jugadorAsistencia, i);
        parcel.writeString(urlGol);
        parcel.writeString(urlAsistencia);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeInt(super.local ? 1 : 0);
        }
        parcel.writeInt(super.minuto);
    }
}
