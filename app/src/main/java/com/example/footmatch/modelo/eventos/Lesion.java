package com.example.footmatch.modelo.eventos;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.R;
import com.example.footmatch.modelo.Jugador;

public class Lesion extends Evento implements Parcelable {
    private Jugador jugadorLesion;
    private String urlLesion;

    protected Lesion(Parcel in) {
        jugadorLesion = in.readParcelable(Jugador.class.getClassLoader());
        urlLesion = in.readString();
        super.minuto = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            super.local = in.readInt() == 1;
        }
    }

    public static final Creator<Lesion> CREATOR = new Creator<Lesion>() {
        @Override
        public Lesion createFromParcel(Parcel in) {
            return new Lesion(in);
        }

        @Override
        public Lesion[] newArray(int size) {
            return new Lesion[size];
        }
    };

    @Override
    public String getPrimerFactor() {
        return jugadorLesion.getNombre();
    }

    @Override
    public String getSegundoFactor() {
        return "";
    }

    @Override
    public int getPrimerUrl() {
        return R.drawable.lesion;
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
        parcel.writeParcelable(jugadorLesion, i);
        parcel.writeString(urlLesion);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeInt(super.local ? 1 : 0);
        }
        parcel.writeInt(super.minuto);
    }
}
