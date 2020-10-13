package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.ArrayList;

public class Items implements Parcelable {
    public String getOR_ITM_ID() {
        return OR_ITM_ID;
    }

    @Override
    public String toString() {
        return "Items{" +
                "OR_ITM_ID='" + OR_ITM_ID + '\'' +
                ", MN_MA_ID='" + MN_MA_ID + '\'' +
                ", NET_PRICE='" + NET_PRICE + '\'' +
                ", DISCOUNT='" + DISCOUNT + '\'' +
                ", TOTALPRICE='" + TOTALPRICE + '\'' +
                ", QUINTITY='" + QUINTITY + '\'' +
                ", OR_MA_ID='" + OR_MA_ID + '\'' +
                ", CREATED_AT='" + CREATED_AT + '\'' +
                ", UPDADATED_AT='" + UPDADATED_AT + '\'' +
                ", NAME='" + NAME + '\'' +
                ", TYPE='" + TYPE + '\'' +
                '}';
    }

    public void setOR_ITM_ID(String OR_ITM_ID) {
        this.OR_ITM_ID = OR_ITM_ID;
    }

    public String getMN_MA_ID() {
        return MN_MA_ID;
    }

    public void setMN_MA_ID(String MN_MA_ID) {
        this.MN_MA_ID = MN_MA_ID;
    }

    public String getNET_PRICE() {
        return NET_PRICE;
    }

    public void setNET_PRICE(String NET_PRICE) {
        this.NET_PRICE = NET_PRICE;
    }

    public String getDISCOUNT() {
        return DISCOUNT;
    }

    public void setDISCOUNT(String DISCOUNT) {
        this.DISCOUNT = DISCOUNT;
    }

    public String getTOTALPRICE() {
        return TOTALPRICE;
    }

    public void setTOTALPRICE(String TOTALPRICE) {
        this.TOTALPRICE = TOTALPRICE;
    }

    public String getQUINTITY() {
        return QUINTITY;
    }

    public void setQUINTITY(String QUINTITY) {
        this.QUINTITY = QUINTITY;
    }

    public String getOR_MA_ID() {
        return OR_MA_ID;
    }

    public void setOR_MA_ID(String OR_MA_ID) {
        this.OR_MA_ID = OR_MA_ID;
    }

    public String getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(String CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public String getUPDADATED_AT() {
        return UPDADATED_AT;
    }

    public void setUPDADATED_AT(String UPDADATED_AT) {
        this.UPDADATED_AT = UPDADATED_AT;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public static Creator<Items> getCREATOR() {
        return CREATOR;
    }

    public Items(String OR_ITM_ID, String MN_MA_ID, String NET_PRICE, String DISCOUNT, String TOTALPRICE, String QUINTITY, String OR_MA_ID, String CREATED_AT, String UPDADATED_AT, String NAME, String TYPE) {
        this.OR_ITM_ID = OR_ITM_ID;
        this.MN_MA_ID = MN_MA_ID;
        this.NET_PRICE = NET_PRICE;
        this.DISCOUNT = DISCOUNT;
        this.TOTALPRICE = TOTALPRICE;
        this.QUINTITY = QUINTITY;
        this.OR_MA_ID = OR_MA_ID;
        this.CREATED_AT = CREATED_AT;
        this.UPDADATED_AT = UPDADATED_AT;
        this.NAME = NAME;
        this.TYPE = TYPE;
    }

    @SerializedName("OR_ITM_ID")
    String OR_ITM_ID;
    @SerializedName("MN_MA_ID")
    String MN_MA_ID;
    @SerializedName("NET_PRICE")
    String NET_PRICE;
    @SerializedName("DISCOUNT")
    String DISCOUNT;
    @SerializedName("TOTALPRICE")
    String TOTALPRICE;
    @SerializedName("QUINTITY")
    String QUINTITY;
    @SerializedName("OR_MA_ID")
    String OR_MA_ID;
    @SerializedName("CREATED_AT")
    String CREATED_AT;
    @SerializedName("UPDADATED_AT")
    String UPDADATED_AT;
    @SerializedName("NAME")
    String NAME;
    @SerializedName("TYPE")
    String TYPE;

    protected Items(Parcel in) {
        OR_ITM_ID = in.readString();
        MN_MA_ID = in.readString();
        NET_PRICE = in.readString();
        DISCOUNT = in.readString();
        TOTALPRICE = in.readString();
        QUINTITY = in.readString();
        OR_MA_ID = in.readString();
        CREATED_AT = in.readString();
        UPDADATED_AT = in.readString();
        NAME = in.readString();
        TYPE = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(OR_ITM_ID);
        parcel.writeString(MN_MA_ID);
        parcel.writeString(NET_PRICE);
        parcel.writeString(DISCOUNT);
        parcel.writeString(TOTALPRICE);
        parcel.writeString(QUINTITY);
        parcel.writeString(OR_MA_ID);
        parcel.writeString(CREATED_AT);
        parcel.writeString(UPDADATED_AT);
        parcel.writeString(NAME);
        parcel.writeString(TYPE);
    }
}