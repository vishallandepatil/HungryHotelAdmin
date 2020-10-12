package com.hungry.hotel.hungryhoteladmin.login.model;

import com.google.gson.annotations.SerializedName;

public class DeliveryBoy {
    public static String ACCOUNT_TYPE = "Account Type";
    public static String DELIVERY_BOY = "DELIVERY BOY";
    public static String HOTEL_ADMIN = "HOTEL";

    @SerializedName("DL_BO_MA_ID")
    private String DL_BO_MA_ID;

    @SerializedName("LNAME")
    private String LNAME;

    @SerializedName("FNAME")
    private String FNAME;

    @SerializedName("MOBILENO")
    private String MOBILENO;

    @SerializedName("IS_MOBILE_VERIFIED")
    private String IS_MOBILE_VERIFIED;

    @SerializedName("IS_ACTIVE")
    private String IS_ACTIVE;

    @SerializedName("ADDRESS")
    private String ADDRESS;

    @SerializedName("EMAIL")
    private String EMAIL;

    @SerializedName("IS_EMAIL_VERIFIED")
    private String IS_EMAIL_VERIFIED;

    @SerializedName("ADHARCARD")
    private String ADHARCARD;

    @SerializedName("PANCARD_ID")
    private String PANCARD_ID;

    @SerializedName("IMG")
    private String IMG;
    @SerializedName("IS_DOCUMENT_VERIFIED")
    private String IS_DOCUMENT_VERIFIED;

    @SerializedName("VOTER_ID")
    private String VOTER_ID;

    @SerializedName("DRIVING_LICEN_ID")
    private String DRIVING_LICEN_ID;

    @SerializedName("LANG")
    private String LANG;

    public static String getAccountType() {
        return ACCOUNT_TYPE;
    }

    public static void setAccountType(String accountType) {
        ACCOUNT_TYPE = accountType;
    }

    public static String getDeliveryBoy() {
        return DELIVERY_BOY;
    }

    public static void setDeliveryBoy(String deliveryBoy) {
        DELIVERY_BOY = deliveryBoy;
    }

    public static String getHotelAdmin() {
        return HOTEL_ADMIN;
    }

    public static void setHotelAdmin(String hotelAdmin) {
        HOTEL_ADMIN = hotelAdmin;
    }

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
        return "DeliveryBoy{" +
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

    @SerializedName("LAT")
    private String LAT;

    @SerializedName("FRANCHAICIES_ID")
    private String FRANCHAICIES_ID;

    public DeliveryBoy() {
    }

    @SerializedName("CITY_MA_ID")
    private String CITY_MA_ID;

    public DeliveryBoy(String DL_BO_MA_ID, String LNAME, String FNAME, String MOBILENO, String IS_MOBILE_VERIFIED, String IS_ACTIVE, String ADDRESS, String EMAIL, String IS_EMAIL_VERIFIED, String ADHARCARD, String PANCARD_ID, String IMG, String IS_DOCUMENT_VERIFIED, String VOTER_ID, String DRIVING_LICEN_ID, String LANG, String LAT, String FRANCHAICIES_ID, String CITY_MA_ID) {
        this.DL_BO_MA_ID = DL_BO_MA_ID;
        this.LNAME = LNAME;
        this.FNAME = FNAME;
        this.MOBILENO = MOBILENO;
        this.IS_MOBILE_VERIFIED = IS_MOBILE_VERIFIED;
        this.IS_ACTIVE = IS_ACTIVE;
        this.ADDRESS = ADDRESS;
        this.EMAIL = EMAIL;
        this.IS_EMAIL_VERIFIED = IS_EMAIL_VERIFIED;
        this.ADHARCARD = ADHARCARD;
        this.PANCARD_ID = PANCARD_ID;
        this.IMG = IMG;
        this.IS_DOCUMENT_VERIFIED = IS_DOCUMENT_VERIFIED;
        this.VOTER_ID = VOTER_ID;
        this.DRIVING_LICEN_ID = DRIVING_LICEN_ID;
        this.LANG = LANG;
        this.LAT = LAT;
        this.FRANCHAICIES_ID = FRANCHAICIES_ID;
        this.CITY_MA_ID = CITY_MA_ID;
    }
}