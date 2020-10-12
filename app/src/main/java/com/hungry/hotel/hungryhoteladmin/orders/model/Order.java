package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class Order implements Parcelable {



    @SerializedName("CM_FIRST_NAME")
    String CM_FIRST_NAME;
    @SerializedName("CM_LAST_NAME")
    String CM_LAST_NAME;
    @SerializedName("CM_MOBILE")
    String CM_MOBILE;
    @SerializedName("CM_GENDER")
    String CM_GENDER;
    @SerializedName("OR_ID")
    String OR_ID;
    @SerializedName("OR_NO")
    String OR_NO;
    @SerializedName("CM_MS_ID")
    String CM_MS_ID;
    @SerializedName("HOT_MS_ID")
    String HOT_MS_ID;
    @SerializedName("OR_STATUS")
    String OR_STATUS;

    @SerializedName("EX_DILIVERY_TIME")
    String EX_DILIVERY_TIME;

    @SerializedName("DL_BOY_STATUS")
    String DL_BOY_STATUS;

    @SerializedName("DL_BO_MA_ID")
    String DL_BO_MA_ID;
    @SerializedName("DL_DATE_TIME")
    String DL_DATE_TIME;

    @SerializedName("RATING")
    String RATING;
     @SerializedName("FEEDBACK")
    String FEEDBACK;
     @SerializedName("DL_AD_MA_ID")
    String DL_AD_MA_ID;
     @SerializedName("PAY_METHOD")
    String PAY_METHOD;
     @SerializedName("PAYMENT_STATUS")
    String PAYMENT_STATUS;
     @SerializedName("NET_TOTAL")
    String NET_TOTAL;
     @SerializedName("TAX")
    String TAX;
     @SerializedName("delivery_fees")
    String delivery_fees;
     @SerializedName("TOTAL")
    String TOTAL;
     @SerializedName("DISCOUNT")
    String DISCOUNT;
     @SerializedName("COMM_PERCENT")
    String COMM_PERCENT;
     @SerializedName("COMM_AMMOUNT")
    String COMM_AMMOUNT;
     @SerializedName("CREATED_AT")
    String CREATED_AT;
     @SerializedName("UPDATED_AT")
    String UPDATED_AT;
     @SerializedName("DB_RATING")
    String DB_RATING;
     @SerializedName("DISPATCH_CODE")
    String DISPATCH_CODE;
     @SerializedName("DB_FEEDBACK")
    String DB_FEEDBACK;
     @SerializedName("LNAME")
    String LNAME;
     @SerializedName("FNAME")
    String FNAME;
     @SerializedName("NAME")
    String NAME;
     @SerializedName("IMG_URL")
    String IMG_URL;
     @SerializedName("LINE1")
    String LINE1;
     @SerializedName("LINE2")
    String LINE2;
     @SerializedName("LANG")
    String LANG;
     @SerializedName("LAT")
    String LAT;

    @SerializedName("items")
    public ArrayList<Items> items;

    public Order(String CM_FIRST_NAME, String CM_LAST_NAME, String CM_MOBILE, String CM_GENDER, String OR_ID, String OR_NO, String CM_MS_ID, String HOT_MS_ID, String OR_STATUS, String EX_DILIVERY_TIME, String DL_BOY_STATUS, String DL_BO_MA_ID, String DL_DATE_TIME, String RATING, String FEEDBACK, String DL_AD_MA_ID, String PAY_METHOD, String PAYMENT_STATUS, String NET_TOTAL, String TAX, String delivery_fees, String TOTAL, String DISCOUNT, String COMM_PERCENT, String COMM_AMMOUNT, String CREATED_AT, String UPDATED_AT, String DB_RATING, String DISPATCH_CODE, String DB_FEEDBACK, String LNAME, String FNAME, String NAME, String IMG_URL, String LINE1, String LINE2, String LANG, String LAT, ArrayList<Items> items) {
        this.CM_FIRST_NAME = CM_FIRST_NAME;
        this.CM_LAST_NAME = CM_LAST_NAME;
        this.CM_MOBILE = CM_MOBILE;
        this.CM_GENDER = CM_GENDER;
        this.OR_ID = OR_ID;
        this.OR_NO = OR_NO;
        this.CM_MS_ID = CM_MS_ID;
        this.HOT_MS_ID = HOT_MS_ID;
        this.OR_STATUS = OR_STATUS;
        this.EX_DILIVERY_TIME = EX_DILIVERY_TIME;
        this.DL_BOY_STATUS = DL_BOY_STATUS;
        this.DL_BO_MA_ID = DL_BO_MA_ID;
        this.DL_DATE_TIME = DL_DATE_TIME;
        this.RATING = RATING;
        this.FEEDBACK = FEEDBACK;
        this.DL_AD_MA_ID = DL_AD_MA_ID;
        this.PAY_METHOD = PAY_METHOD;
        this.PAYMENT_STATUS = PAYMENT_STATUS;
        this.NET_TOTAL = NET_TOTAL;
        this.TAX = TAX;
        this.delivery_fees = delivery_fees;
        this.TOTAL = TOTAL;
        this.DISCOUNT = DISCOUNT;
        this.COMM_PERCENT = COMM_PERCENT;
        this.COMM_AMMOUNT = COMM_AMMOUNT;
        this.CREATED_AT = CREATED_AT;
        this.UPDATED_AT = UPDATED_AT;
        this.DB_RATING = DB_RATING;
        this.DISPATCH_CODE = DISPATCH_CODE;
        this.DB_FEEDBACK = DB_FEEDBACK;
        this.LNAME = LNAME;
        this.FNAME = FNAME;
        this.NAME = NAME;
        this.IMG_URL = IMG_URL;
        this.LINE1 = LINE1;
        this.LINE2 = LINE2;
        this.LANG = LANG;
        this.LAT = LAT;
        this.items = items;
    }

    protected Order(Parcel in) {
        CM_FIRST_NAME = in.readString();
        CM_LAST_NAME = in.readString();
        CM_MOBILE = in.readString();
        CM_GENDER = in.readString();
        OR_ID = in.readString();
        OR_NO = in.readString();
        CM_MS_ID = in.readString();
        HOT_MS_ID = in.readString();
        OR_STATUS = in.readString();
        EX_DILIVERY_TIME = in.readString();
        DL_BOY_STATUS = in.readString();
        DL_BO_MA_ID = in.readString();
        DL_DATE_TIME = in.readString();
        RATING = in.readString();
        FEEDBACK = in.readString();
        DL_AD_MA_ID = in.readString();
        PAY_METHOD = in.readString();
        PAYMENT_STATUS = in.readString();
        NET_TOTAL = in.readString();
        TAX = in.readString();
        delivery_fees = in.readString();
        TOTAL = in.readString();
        DISCOUNT = in.readString();
        COMM_PERCENT = in.readString();
        COMM_AMMOUNT = in.readString();
        CREATED_AT = in.readString();
        UPDATED_AT = in.readString();
        DB_RATING = in.readString();
        DISPATCH_CODE = in.readString();
        DB_FEEDBACK = in.readString();
        LNAME = in.readString();
        FNAME = in.readString();
        NAME = in.readString();
        IMG_URL = in.readString();
        LINE1 = in.readString();
        LINE2 = in.readString();
        LANG = in.readString();
        LAT = in.readString();
        items = in.createTypedArrayList(Items.CREATOR);
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getCM_FIRST_NAME() {
        return CM_FIRST_NAME;
    }

    public void setCM_FIRST_NAME(String CM_FIRST_NAME) {
        this.CM_FIRST_NAME = CM_FIRST_NAME;
    }

    public String getCM_LAST_NAME() {
        return CM_LAST_NAME;
    }

    public void setCM_LAST_NAME(String CM_LAST_NAME) {
        this.CM_LAST_NAME = CM_LAST_NAME;
    }

    public String getCM_MOBILE() {
        return CM_MOBILE;
    }

    public void setCM_MOBILE(String CM_MOBILE) {
        this.CM_MOBILE = CM_MOBILE;
    }

    public String getCM_GENDER() {
        return CM_GENDER;
    }

    public void setCM_GENDER(String CM_GENDER) {
        this.CM_GENDER = CM_GENDER;
    }

    public String getOR_ID() {
        return OR_ID;
    }

    public void setOR_ID(String OR_ID) {
        this.OR_ID = OR_ID;
    }

    public String getOR_NO() {
        return OR_NO;
    }

    public void setOR_NO(String OR_NO) {
        this.OR_NO = OR_NO;
    }

    public String getCM_MS_ID() {
        return CM_MS_ID;
    }

    public void setCM_MS_ID(String CM_MS_ID) {
        this.CM_MS_ID = CM_MS_ID;
    }

    public String getHOT_MS_ID() {
        return HOT_MS_ID;
    }

    public void setHOT_MS_ID(String HOT_MS_ID) {
        this.HOT_MS_ID = HOT_MS_ID;
    }

    public String getOR_STATUS() {
        return OR_STATUS;
    }

    public void setOR_STATUS(String OR_STATUS) {
        this.OR_STATUS = OR_STATUS;
    }

    public String getEX_DILIVERY_TIME() {
        return EX_DILIVERY_TIME;
    }

    public void setEX_DILIVERY_TIME(String EX_DILIVERY_TIME) {
        this.EX_DILIVERY_TIME = EX_DILIVERY_TIME;
    }

    public String getDL_BOY_STATUS() {
        return DL_BOY_STATUS;
    }

    public void setDL_BOY_STATUS(String DL_BOY_STATUS) {
        this.DL_BOY_STATUS = DL_BOY_STATUS;
    }

    public String getDL_BO_MA_ID() {
        return DL_BO_MA_ID;
    }

    public void setDL_BO_MA_ID(String DL_BO_MA_ID) {
        this.DL_BO_MA_ID = DL_BO_MA_ID;
    }

    public String getDL_DATE_TIME() {
        return DL_DATE_TIME;
    }

    public void setDL_DATE_TIME(String DL_DATE_TIME) {
        this.DL_DATE_TIME = DL_DATE_TIME;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = RATING;
    }

    public String getFEEDBACK() {
        return FEEDBACK;
    }

    public void setFEEDBACK(String FEEDBACK) {
        this.FEEDBACK = FEEDBACK;
    }

    public String getDL_AD_MA_ID() {
        return DL_AD_MA_ID;
    }

    public void setDL_AD_MA_ID(String DL_AD_MA_ID) {
        this.DL_AD_MA_ID = DL_AD_MA_ID;
    }

    public String getPAY_METHOD() {
        return PAY_METHOD;
    }

    public void setPAY_METHOD(String PAY_METHOD) {
        this.PAY_METHOD = PAY_METHOD;
    }

    public String getPAYMENT_STATUS() {
        return PAYMENT_STATUS;
    }

    public void setPAYMENT_STATUS(String PAYMENT_STATUS) {
        this.PAYMENT_STATUS = PAYMENT_STATUS;
    }

    public String getNET_TOTAL() {
        return NET_TOTAL;
    }

    public void setNET_TOTAL(String NET_TOTAL) {
        this.NET_TOTAL = NET_TOTAL;
    }

    public String getTAX() {
        return TAX;
    }

    public void setTAX(String TAX) {
        this.TAX = TAX;
    }

    public String getDelivery_fees() {
        return delivery_fees;
    }

    public void setDelivery_fees(String delivery_fees) {
        this.delivery_fees = delivery_fees;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(String TOTAL) {
        this.TOTAL = TOTAL;
    }

    public String getDISCOUNT() {
        return DISCOUNT;
    }

    public void setDISCOUNT(String DISCOUNT) {
        this.DISCOUNT = DISCOUNT;
    }

    public String getCOMM_PERCENT() {
        return COMM_PERCENT;
    }

    public void setCOMM_PERCENT(String COMM_PERCENT) {
        this.COMM_PERCENT = COMM_PERCENT;
    }

    public String getCOMM_AMMOUNT() {
        return COMM_AMMOUNT;
    }

    public void setCOMM_AMMOUNT(String COMM_AMMOUNT) {
        this.COMM_AMMOUNT = COMM_AMMOUNT;
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

    public String getDB_RATING() {
        return DB_RATING;
    }

    public void setDB_RATING(String DB_RATING) {
        this.DB_RATING = DB_RATING;
    }

    public String getDISPATCH_CODE() {
        return DISPATCH_CODE;
    }

    public void setDISPATCH_CODE(String DISPATCH_CODE) {
        this.DISPATCH_CODE = DISPATCH_CODE;
    }

    public String getDB_FEEDBACK() {
        return DB_FEEDBACK;
    }

    public void setDB_FEEDBACK(String DB_FEEDBACK) {
        this.DB_FEEDBACK = DB_FEEDBACK;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getIMG_URL() {
        return IMG_URL;
    }

    public void setIMG_URL(String IMG_URL) {
        this.IMG_URL = IMG_URL;
    }

    public String getLINE1() {
        return LINE1;
    }

    public void setLINE1(String LINE1) {
        this.LINE1 = LINE1;
    }

    public String getLINE2() {
        return LINE2;
    }

    public void setLINE2(String LINE2) {
        this.LINE2 = LINE2;
    }

    public String getLANG() {
        return LANG;
    }

    public void setLANG(String LANG) {
        this.LANG = LANG;
    }

    public String getLAT() {
        return LAT;
    }

    public void setLAT(String LAT) {
        this.LAT = LAT;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "CM_FIRST_NAME='" + CM_FIRST_NAME + '\'' +
                ", CM_LAST_NAME='" + CM_LAST_NAME + '\'' +
                ", CM_MOBILE='" + CM_MOBILE + '\'' +
                ", CM_GENDER='" + CM_GENDER + '\'' +
                ", OR_ID='" + OR_ID + '\'' +
                ", OR_NO='" + OR_NO + '\'' +
                ", CM_MS_ID='" + CM_MS_ID + '\'' +
                ", HOT_MS_ID='" + HOT_MS_ID + '\'' +
                ", OR_STATUS='" + OR_STATUS + '\'' +
                ", EX_DILIVERY_TIME='" + EX_DILIVERY_TIME + '\'' +
                ", DL_BOY_STATUS='" + DL_BOY_STATUS + '\'' +
                ", DL_BO_MA_ID='" + DL_BO_MA_ID + '\'' +
                ", DL_DATE_TIME='" + DL_DATE_TIME + '\'' +
                ", RATING='" + RATING + '\'' +
                ", FEEDBACK='" + FEEDBACK + '\'' +
                ", DL_AD_MA_ID='" + DL_AD_MA_ID + '\'' +
                ", PAY_METHOD='" + PAY_METHOD + '\'' +
                ", PAYMENT_STATUS='" + PAYMENT_STATUS + '\'' +
                ", NET_TOTAL='" + NET_TOTAL + '\'' +
                ", TAX='" + TAX + '\'' +
                ", delivery_fees='" + delivery_fees + '\'' +
                ", TOTAL='" + TOTAL + '\'' +
                ", DISCOUNT='" + DISCOUNT + '\'' +
                ", COMM_PERCENT='" + COMM_PERCENT + '\'' +
                ", COMM_AMMOUNT='" + COMM_AMMOUNT + '\'' +
                ", CREATED_AT='" + CREATED_AT + '\'' +
                ", UPDATED_AT='" + UPDATED_AT + '\'' +
                ", DB_RATING='" + DB_RATING + '\'' +
                ", DISPATCH_CODE='" + DISPATCH_CODE + '\'' +
                ", DB_FEEDBACK='" + DB_FEEDBACK + '\'' +
                ", LNAME='" + LNAME + '\'' +
                ", FNAME='" + FNAME + '\'' +
                ", NAME='" + NAME + '\'' +
                ", IMG_URL='" + IMG_URL + '\'' +
                ", LINE1='" + LINE1 + '\'' +
                ", LINE2='" + LINE2 + '\'' +
                ", LANG='" + LANG + '\'' +
                ", LAT='" + LAT + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(CM_FIRST_NAME);
        parcel.writeString(CM_LAST_NAME);
        parcel.writeString(CM_MOBILE);
        parcel.writeString(CM_GENDER);
        parcel.writeString(OR_ID);
        parcel.writeString(OR_NO);
        parcel.writeString(CM_MS_ID);
        parcel.writeString(HOT_MS_ID);
        parcel.writeString(OR_STATUS);
        parcel.writeString(EX_DILIVERY_TIME);
        parcel.writeString(DL_BOY_STATUS);
        parcel.writeString(DL_BO_MA_ID);
        parcel.writeString(DL_DATE_TIME);
        parcel.writeString(RATING);
        parcel.writeString(FEEDBACK);
        parcel.writeString(DL_AD_MA_ID);
        parcel.writeString(PAY_METHOD);
        parcel.writeString(PAYMENT_STATUS);
        parcel.writeString(NET_TOTAL);
        parcel.writeString(TAX);
        parcel.writeString(delivery_fees);
        parcel.writeString(TOTAL);
        parcel.writeString(DISCOUNT);
        parcel.writeString(COMM_PERCENT);
        parcel.writeString(COMM_AMMOUNT);
        parcel.writeString(CREATED_AT);
        parcel.writeString(UPDATED_AT);
        parcel.writeString(DB_RATING);
        parcel.writeString(DISPATCH_CODE);
        parcel.writeString(DB_FEEDBACK);
        parcel.writeString(LNAME);
        parcel.writeString(FNAME);
        parcel.writeString(NAME);
        parcel.writeString(IMG_URL);
        parcel.writeString(LINE1);
        parcel.writeString(LINE2);
        parcel.writeString(LANG);
        parcel.writeString(LAT);
        parcel.writeTypedList(items);
    }
}