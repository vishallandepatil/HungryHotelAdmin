package com.hungry.hotel.hungryhoteladmin.restaurentmenu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public  class  Dish implements Parcelable {
    public Dish() {
    }

    public Dish(String MENU_MA_ID, String NAME, String AMOUNT, String TYPE, String QUNTITY, String DESCRIPTION, String CATEGORY, String START_TIME, String END_TIME, String IS_SHOWN, String HOT_MA_ID, String ADDED_BY, String path, String PRIORITY_ID, String CREATED_AT, String UPDATED_AT) {
        this.MENU_MA_ID = MENU_MA_ID;
        this.NAME = NAME;
        this.AMOUNT = AMOUNT;
        this.TYPE = TYPE;
        this.QUNTITY = QUNTITY;
        this.DESCRIPTION = DESCRIPTION;
        this.CATEGORY = CATEGORY;
        this.START_TIME = START_TIME;
        this.END_TIME = END_TIME;
        this.IS_SHOWN = IS_SHOWN;
        this.HOT_MA_ID = HOT_MA_ID;
        this.ADDED_BY = ADDED_BY;
        this.path = path;
        this.PRIORITY_ID = PRIORITY_ID;
        this.CREATED_AT = CREATED_AT;
        this.UPDATED_AT = UPDATED_AT;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "MENU_MA_ID='" + MENU_MA_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", AMOUNT='" + AMOUNT + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", QUNTITY='" + QUNTITY + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", CATEGORY='" + CATEGORY + '\'' +
                ", START_TIME='" + START_TIME + '\'' +
                ", END_TIME='" + END_TIME + '\'' +
                ", IS_SHOWN='" + IS_SHOWN + '\'' +
                ", HOT_MA_ID='" + HOT_MA_ID + '\'' +
                ", ADDED_BY='" + ADDED_BY + '\'' +
                ", path='" + path + '\'' +
                ", PRIORITY_ID='" + PRIORITY_ID + '\'' +
                ", CREATED_AT='" + CREATED_AT + '\'' +
                ", UPDATED_AT='" + UPDATED_AT + '\'' +
                '}';
    }

    @SerializedName("MENU_MA_ID")
    String MENU_MA_ID;
    @SerializedName("NAME")
    String NAME;
    @SerializedName("AMOUNT")
    String AMOUNT;

    protected Dish(Parcel in) {
        MENU_MA_ID = in.readString();
        NAME = in.readString();
        AMOUNT = in.readString();
        TYPE = in.readString();
        QUNTITY = in.readString();
        DESCRIPTION = in.readString();
        CATEGORY = in.readString();
        START_TIME = in.readString();
        END_TIME = in.readString();
        IS_SHOWN = in.readString();
        HOT_MA_ID = in.readString();
        ADDED_BY = in.readString();
        path = in.readString();
        PRIORITY_ID = in.readString();
        CREATED_AT = in.readString();
        UPDATED_AT = in.readString();
    }

    public static final Creator<Dish> CREATOR = new Creator<Dish>() {
        @Override
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        @Override
        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };

    public String getMENU_MA_ID() {
        return MENU_MA_ID;
    }

    public void setMENU_MA_ID(String MENU_MA_ID) {
        this.MENU_MA_ID = MENU_MA_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getQUNTITY() {
        return QUNTITY;
    }

    public void setQUNTITY(String QUNTITY) {
        this.QUNTITY = QUNTITY;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

    public String getIS_SHOWN() {
        return IS_SHOWN;
    }

    public void setIS_SHOWN(String IS_SHOWN) {
        this.IS_SHOWN = IS_SHOWN;
    }

    public String getHOT_MA_ID() {
        return HOT_MA_ID;
    }

    public void setHOT_MA_ID(String HOT_MA_ID) {
        this.HOT_MA_ID = HOT_MA_ID;
    }

    public String getADDED_BY() {
        return ADDED_BY;
    }

    public void setADDED_BY(String ADDED_BY) {
        this.ADDED_BY = ADDED_BY;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPRIORITY_ID() {
        return PRIORITY_ID;
    }

    public void setPRIORITY_ID(String PRIORITY_ID) {
        this.PRIORITY_ID = PRIORITY_ID;
    }

    public String getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(String CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public String getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(String UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }

    @SerializedName("TYPE")
    String TYPE;
    @SerializedName("QUNTITY")
    String QUNTITY;
    @SerializedName("DESCRIPTION")
    String DESCRIPTION;
    @SerializedName("CATEGORY")
    String CATEGORY;
    @SerializedName("START_TIME")
    String START_TIME;
    @SerializedName("END_TIME")
    String END_TIME;
    @SerializedName("IS_SHOWN")
    String IS_SHOWN;
    @SerializedName("HOT_MA_ID")
    String HOT_MA_ID;
    @SerializedName("ADDED_BY")
    String ADDED_BY;
    @SerializedName("path")
    String path;
    @SerializedName("PRIORITY_ID")
    String PRIORITY_ID;
    @SerializedName("CREATED_AT")
    String CREATED_AT;
    @SerializedName("UPDATED_AT")
    String UPDATED_AT;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(MENU_MA_ID);
        parcel.writeString(NAME);
        parcel.writeString(AMOUNT);
        parcel.writeString(TYPE);
        parcel.writeString(QUNTITY);
        parcel.writeString(DESCRIPTION);
        parcel.writeString(CATEGORY);
        parcel.writeString(START_TIME);
        parcel.writeString(END_TIME);
        parcel.writeString(IS_SHOWN);
        parcel.writeString(HOT_MA_ID);
        parcel.writeString(ADDED_BY);
        parcel.writeString(path);
        parcel.writeString(PRIORITY_ID);
        parcel.writeString(CREATED_AT);
        parcel.writeString(UPDATED_AT);
    }
}
