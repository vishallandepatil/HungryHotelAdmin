package com.hungry.hotel.hungryhoteladmin.dashboard.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Dashboard implements Parcelable {

    @SerializedName("STATUS")
    String STATUS;
    @SerializedName("Total")
    String Total;
    @SerializedName("title")
    String title;

    @Override
    public String toString() {
        return "Dashboard{" +
                "STATUS='" + STATUS + '\'' +
                ", Total='" + Total + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Creator<Dashboard> getCREATOR() {
        return CREATOR;
    }

    public Dashboard(String STATUS, String total, String title) {
        this.STATUS = STATUS;
        Total = total;
        this.title = title;
    }

    protected Dashboard(Parcel in) {
        STATUS = in.readString();
        Total = in.readString();
        title = in.readString();
    }

    public static final Creator<Dashboard> CREATOR = new Creator<Dashboard>() {
        @Override
        public Dashboard createFromParcel(Parcel in) {
            return new Dashboard(in);
        }

        @Override
        public Dashboard[] newArray(int size) {
            return new Dashboard[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(STATUS);
        parcel.writeString(Total);
        parcel.writeString(title);
    }
}
