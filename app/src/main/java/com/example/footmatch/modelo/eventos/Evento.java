package com.example.footmatch.modelo.eventos;

import android.os.Parcelable;

public abstract class Evento implements Parcelable {
    protected int minuto;
    protected boolean local; // true si el evento es del equipo local y false si es visitante
    public abstract String getPrimerFactor();
    public abstract String getSegundoFactor();
    public String getMinuto() {
        return minuto + "'";
    }
    public abstract int getPrimerUrl();
    public abstract int getSegundoUrl();

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
}