package com.example.footmatch.modelo;
import android.os.Parcel;
import android.os.Parcelable;


public class BuscadorId implements Parcelable {
    private int id;
    private String utcDate;

    public BuscadorId(int id, String utcDate) {
        this.id = id;
        this.utcDate = utcDate;
    }

    protected BuscadorId(Parcel in) {
        id = in.readInt();
        utcDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(utcDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BuscadorId> CREATOR = new Creator<BuscadorId>() {
        @Override
        public BuscadorId createFromParcel(Parcel in) {
            return new BuscadorId(in);
        }

        @Override
        public BuscadorId[] newArray(int size) {
            return new BuscadorId[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getUtcDate() {
        return utcDate;
    }

}