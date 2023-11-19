package com.example.footmatch.modelo.eventos;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.example.footmatch.R;

public class Penalti extends Evento implements Parcelable {
    private String jugadorPenalti;
    private String urlPenalti;
    public Penalti(String jugadorPenalti, int minute, boolean local) {
        super.minuto = minute;
        super.local = local;
        this.jugadorPenalti = jugadorPenalti;
    }
    protected Penalti(Parcel in) {
        jugadorPenalti = in.readString();
        urlPenalti = in.readString();
        super.minuto = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            super.local = in.readInt() == 1;
        }
    }

    public static final Creator<Penalti> CREATOR = new Creator<Penalti>() {
        @Override
        public Penalti createFromParcel(Parcel in) {
            return new Penalti(in);
        }

        @Override
        public Penalti[] newArray(int size) {
            return new Penalti[size];
        }
    };

    @Override
    public String getPrimerFactor() {
        return jugadorPenalti;
    }

    @Override
    public String getSegundoFactor() {
        return "";
    }

    @Override
    public int getPrimerUrl() {
        return R.drawable.penalti;
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
        parcel.writeString(jugadorPenalti);
        parcel.writeString(urlPenalti);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeInt(super.local ? 1 : 0);
        }
        parcel.writeInt(super.minuto);
    }
}