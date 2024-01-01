package com.example.footmatch.datos.modelos;
import android.os.Parcel;
import android.os.Parcelable;


public class BuscadorId implements Parcelable {
    private int id;
    private int localId;
    private int awayId;

    private String utcDate;

    public BuscadorId(int id, String utcDate, int id1, int id2) {
        this.id = id;
        this.utcDate = utcDate;
        this.localId = id1;
        this.awayId = id2;
    }

    protected BuscadorId(Parcel in) {
        id = in.readInt();
        utcDate = in.readString();
        localId = in.readInt();
        awayId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(utcDate);
        dest.writeInt(localId);
        dest.writeInt(awayId);
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

    public void setId(int id) {
        this.id = id;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public int getAwayId() {
        return awayId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }
}