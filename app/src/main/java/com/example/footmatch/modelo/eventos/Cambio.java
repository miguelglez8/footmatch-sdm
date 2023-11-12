package com.example.footmatch.modelo.eventos;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.R;
import com.example.footmatch.modelo.Jugador;

public class Cambio extends Evento implements Parcelable {
    private Jugador jugadorSale;
    private Jugador jugadorEntra;
    private String urlCambio;

    protected Cambio(Parcel in) {
        jugadorSale = in.readParcelable(Jugador.class.getClassLoader());
        jugadorEntra = in.readParcelable(Jugador.class.getClassLoader());
        urlCambio = in.readString();
        super.minuto = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            super.local = in.readInt() == 1;
        }
    }

    public static final Creator<Cambio> CREATOR = new Creator<Cambio>() {
        @Override
        public Cambio createFromParcel(Parcel in) {
            return new Cambio(in);
        }

        @Override
        public Cambio[] newArray(int size) {
            return new Cambio[size];
        }
    };

    @Override
    public String getPrimerFactor() {
        return jugadorEntra.getNombre();
    }

    @Override
    public String getSegundoFactor() {
        return jugadorSale.getNombre();
    }

    @Override
    public int getPrimerUrl() {
        return R.drawable.intercambio;
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
        parcel.writeParcelable(jugadorSale, i);
        parcel.writeParcelable(jugadorEntra, i);
        parcel.writeString(urlCambio);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeInt(super.local ? 1 : 0);
        }
        parcel.writeInt(super.minuto);
    }
}
