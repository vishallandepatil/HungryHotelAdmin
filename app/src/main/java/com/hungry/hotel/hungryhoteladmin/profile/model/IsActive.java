package com.hungry.hotel.hungryhoteladmin.profile.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public  class IsActive implements Parcelable {
    public IsActive() {
    }

    @SerializedName("DL_BO_MA_ID")
    String DL_BO_MA_ID;
    @SerializedName("LNAME")
    String LNAME;
    @SerializedName("FNAME")
    String FNAME;
    @SerializedName("MOBILENO")
    String MOBILENO;
    @SerializedName("IS_MOBILE_VERIFIED")
    String IS_MOBILE_VERIFIED;
    @SerializedName("IS_ACTIVE")
    String IS_ACTIVE;
    @SerializedName("ADDRESS")
    String ADDRESS;
    @SerializedName("EMAIL")
    String EMAIL;
    @SerializedName("IS_EMAIL_VERIFIED")
    String IS_EMAIL_VERIFIED;
    @SerializedName("ADHARCARD")
    String ADHARCARD;
    @SerializedName("PANCARD_ID")
    String PANCARD_ID;
    @SerializedName("IMG")
    String IMG;
    @SerializedName("IS_DOCUMENT_VERIFIED")
    String IS_DOCUMENT_VERIFIED;
    @SerializedName("VOTER_ID")
    String VOTER_ID;
    @SerializedName("DRIVING_LICEN_ID")
    String DRIVING_LICEN_ID;
    @SerializedName("LANG")
    String LANG;
    @SerializedName("LAT")
    String LAT;
    @SerializedName("FRANCHAICIES_ID")
    String FRANCHAICIES_ID;
    @SerializedName("CITY_MA_ID")
    String CITY_MA_ID;

    protected IsActive(Parcel in) {
        DL_BO_MA_ID = in.readString();
        LNAME = in.readString();
        FNAME = in.readString();
        MOBILENO = in.readString();
        IS_MOBILE_VERIFIED = in.readString();
        IS_ACTIVE = in.readString();
        ADDRESS = in.readString();
        EMAIL = in.readString();
        IS_EMAIL_VERIFIED = in.readString();
        ADHARCARD = in.readString();
        PANCARD_ID = in.readString();
        IMG = in.readString();
        IS_DOCUMENT_VERIFIED = in.readString();
        VOTER_ID = in.readString();
        DRIVING_LICEN_ID = in.readString();
        LANG = in.readString();
        LAT = in.readString();
        FRANCHAICIES_ID = in.readString();
        CITY_MA_ID = in.readString();
    }

    public static final Creator<IsActive> CREATOR = new Creator<IsActive>() {
        @Override
        public IsActive createFromParcel(Parcel in) {
            return new IsActive(in);
        }

        @Override
        public IsActive[] newArray(int size) {
            return new IsActive[size];
        }
    };

    public String getDL_BO_MA_ID() {
        return DL_BO_MA_ID;
    }

    public void setDL_BO_MA_ID(String DL_BO_MA_ID) {
        this.DL_BO_MA_ID = DL_BO_MA_ID;
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

    public String getMOBILENO() {
        return MOBILENO;
    }

    public void setMOBILENO(String MOBILENO) {
        this.MOBILENO = MOBILENO;
    }

    public String getIS_MOBILE_VERIFIED() {
        return IS_MOBILE_VERIFIED;
    }

    public void setIS_MOBILE_VERIFIED(String IS_MOBILE_VERIFIED) {
        this.IS_MOBILE_VERIFIED = IS_MOBILE_VERIFIED;
    }

    public String getIS_ACTIVE() {
        return IS_ACTIVE;
    }

    public void setIS_ACTIVE(String IS_ACTIVE) {
        this.IS_ACTIVE = IS_ACTIVE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getIS_EMAIL_VERIFIED() {
        return IS_EMAIL_VERIFIED;
    }

    public void setIS_EMAIL_VERIFIED(String IS_EMAIL_VERIFIED) {
        this.IS_EMAIL_VERIFIED = IS_EMAIL_VERIFIED;
    }

    public String getADHARCARD() {
        return ADHARCARD;
    }

    public void setADHARCARD(String ADHARCARD) {
        this.ADHARCARD = ADHARCARD;
    }

    public String getPANCARD_ID() {
        return PANCARD_ID;
    }

    public void setPANCARD_ID(String PANCARD_ID) {
        this.PANCARD_ID = PANCARD_ID;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }

    public String getIS_DOCUMENT_VERIFIED() {
        return IS_DOCUMENT_VERIFIED;
    }

    public void setIS_DOCUMENT_VERIFIED(String IS_DOCUMENT_VERIFIED) {
        this.IS_DOCUMENT_VERIFIED = IS_DOCUMENT_VERIFIED;
    }

    public String getVOTER_ID() {
        return VOTER_ID;
    }

    public void setVOTER_ID(String VOTER_ID) {
        this.VOTER_ID = VOTER_ID;
    }

    public String getDRIVING_LICEN_ID() {
        return DRIVING_LICEN_ID;
    }

    public void setDRIVING_LICEN_ID(String DRIVING_LICEN_ID) {
        this.DRIVING_LICEN_ID = DRIVING_LICEN_ID;
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

    public String getFRANCHAICIES_ID() {
        return FRANCHAICIES_ID;
    }

    public void setFRANCHAICIES_ID(String FRANCHAICIES_ID) {
        this.FRANCHAICIES_ID = FRANCHAICIES_ID;
    }

    public String getCITY_MA_ID() {
        return CITY_MA_ID;
    }

    public void setCITY_MA_ID(String CITY_MA_ID) {
        this.CITY_MA_ID = CITY_MA_ID;
    }

    @Override
    public String toString() {
        return "IsActive{" +
                "DL_BO_MA_ID='" + DL_BO_MA_ID + '\'' +
                ", LNAME='" + LNAME + '\'' +
                ", FNAME='" + FNAME + '\'' +
                ", MOBILENO='" + MOBILENO + '\'' +
                ", IS_MOBILE_VERIFIED='" + IS_MOBILE_VERIFIED + '\'' +
                ", IS_ACTIVE='" + IS_ACTIVE + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", IS_EMAIL_VERIFIED='" + IS_EMAIL_VERIFIED + '\'' +
                ", ADHARCARD='" + ADHARCARD + '\'' +
                ", PANCARD_ID='" + PANCARD_ID + '\'' +
                ", IMG='" + IMG + '\'' +
                ", IS_DOCUMENT_VERIFIED='" + IS_DOCUMENT_VERIFIED + '\'' +
                ", VOTER_ID='" + VOTER_ID + '\'' +
                ", DRIVING_LICEN_ID='" + DRIVING_LICEN_ID + '\'' +
                ", LANG='" + LANG + '\'' +
                ", LAT='" + LAT + '\'' +
                ", FRANCHAICIES_ID='" + FRANCHAICIES_ID + '\'' +
                ", CITY_MA_ID='" + CITY_MA_ID + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(DL_BO_MA_ID);
        parcel.writeString(LNAME);
        parcel.writeString(FNAME);
        parcel.writeString(MOBILENO);
        parcel.writeString(IS_MOBILE_VERIFIED);
        parcel.writeString(IS_ACTIVE);
        parcel.writeString(ADDRESS);
        parcel.writeString(EMAIL);
        parcel.writeString(IS_EMAIL_VERIFIED);
        parcel.writeString(ADHARCARD);
        parcel.writeString(PANCARD_ID);
        parcel.writeString(IMG);
        parcel.writeString(IS_DOCUMENT_VERIFIED);
        parcel.writeString(VOTER_ID);
        parcel.writeString(DRIVING_LICEN_ID);
        parcel.writeString(LANG);
        parcel.writeString(LAT);
        parcel.writeString(FRANCHAICIES_ID);
        parcel.writeString(CITY_MA_ID);
    }
}
