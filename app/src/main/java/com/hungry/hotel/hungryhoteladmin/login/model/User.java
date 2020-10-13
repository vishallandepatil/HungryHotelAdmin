package com.hungry.hotel.hungryhoteladmin.login.model;

import com.google.gson.annotations.SerializedName;

public class User {
    public static String ACCOUNT_TYPE = "Account Type";

    public static String DELIVERY_BOY = "DELIVERY BOY";
    public static String HOTEL_ADMIN = "HOTEL";

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", LANG='" + LANG + '\'' +
                ", LAT='" + LAT + '\'' +
                ", GOOGLE_ID='" + GOOGLE_ID + '\'' +
                ", VEG_ONLY='" + VEG_ONLY + '\'' +
                ", IMG_URL='" + IMG_URL + '\'' +
                ", START_TIME='" + START_TIME + '\'' +
                ", END_TIME='" + END_TIME + '\'' +
                ", DELIVER_IN='" + DELIVER_IN + '\'' +
                ", MEAL_TYPE='" + MEAL_TYPE + '\'' +
                ", CI_MA_ID='" + CI_MA_ID + '\'' +
                ", RATTING='" + RATTING + '\'' +
                ", REG_ID='" + REG_ID + '\'' +
                ", PAN_NO='" + PAN_NO + '\'' +
                ", MOBILE_NO='" + MOBILE_NO + '\'' +
                ", IS_ACTIVE='" + IS_ACTIVE + '\'' +
                ", franchaices='" + franchaices + '\'' +
                '}';
    }

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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
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

    public String getGOOGLE_ID() {
        return GOOGLE_ID;
    }

    public void setGOOGLE_ID(String GOOGLE_ID) {
        this.GOOGLE_ID = GOOGLE_ID;
    }

    public String getVEG_ONLY() {
        return VEG_ONLY;
    }

    public void setVEG_ONLY(String VEG_ONLY) {
        this.VEG_ONLY = VEG_ONLY;
    }

    public String getIMG_URL() {
        return IMG_URL;
    }

    public void setIMG_URL(String IMG_URL) {
        this.IMG_URL = IMG_URL;
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
=======
    public static String DELIVERY_BOY = "Delivery Boy";
    public static String HOTEL_ADMIN = "Hotel";
    private String userName;
    private String password;
    private String accountType;
    String otp;
    private boolean isDeliveryBoy = true;

    @SerializedName("ID")
    private String id;
    @SerializedName("NAME")
    private String name;
    @SerializedName("GOOGLE_ID")
    private String googleId;
    @SerializedName("Y")
    private String vegOnly;
    @SerializedName("IMG_URL")
    private String hotelImageUrl;
    @SerializedName("START_TIME")
    private String hotelStartTime;
    @SerializedName("END_TIME")
    private String hotelEndTime;
    @SerializedName("DELIVER_IN")
    private String deliverIn;
    @SerializedName("MEAL_TYPE")
    private String mealType;
    @SerializedName("CI_MA_ID")
    private String hotelCityMasterId;
    @SerializedName("RATTING")
    private String hotelRating;
    @SerializedName("REG_ID")
    private String hotelRegId;
    @SerializedName("PAN_NO")
    private String hotelPanNo;
    @SerializedName("MOBILE_NO")
    private String hotelMobileNo;
    @SerializedName("franchaices")
    private String frenchies;
    @SerializedName("DL_BO_MA_ID")
    private String deliveryBoyMasterId;
    @SerializedName("FNAME")
    private String firstName;
    @SerializedName("LNAME")
    private String lastName;
    @SerializedName("MOBILENO")
    private String mobileNumber;
    @SerializedName("IS_MOBILE_VERIFIED")
    private String isMobileVerified;
    @SerializedName("IS_ACTIVE")
    private String isActive;
    @SerializedName("ADDRESS")
    private String address;
    @SerializedName("EMAIL")
    private String emailId;
    @SerializedName("IS_EMAIL_VERIFIED")
    private String isEmailVerified;
    @SerializedName("ADHARCARD")
    private String aadharCard;
    @SerializedName("PANCARD_ID")
    private String panCard;
    @SerializedName("IMG")
    private String img;
    @SerializedName("IS_DOCUMENT_VERIFIED")
    private String isDocumentVerified;
    @SerializedName("VOTER_ID")
    private String voterId;
    @SerializedName("DRIVING_LICEN_ID")
    private String drivingLicenceId;
    @SerializedName("LANG")
    private String lang;
    @SerializedName("LAT")
    private String lat;
    @SerializedName("FRANCHAICIES_ID")
    private String franchicieId;
    @SerializedName("CITY_MA_ID")
    private String cityMasterId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getREG_ID() {
        return REG_ID;
    }

    public void setREG_ID(String REG_ID) {
        this.REG_ID = REG_ID;
    }

    public String getPAN_NO() {
        return PAN_NO;
    }

    public void setPAN_NO(String PAN_NO) {
        this.PAN_NO = PAN_NO;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getIS_ACTIVE() {
        return IS_ACTIVE;
    }

    public void setIS_ACTIVE(String IS_ACTIVE) {
        this.IS_ACTIVE = IS_ACTIVE;
    }

    public String getFranchaices() {
        return franchaices;
    }

    public void setFranchaices(String franchaices) {
        this.franchaices = franchaices;
    }

    public User(String ID, String NAME, String ADDRESS, String LANG, String LAT, String GOOGLE_ID, String VEG_ONLY, String IMG_URL, String START_TIME, String END_TIME, String DELIVER_IN, String MEAL_TYPE, String CI_MA_ID, String RATTING, String REG_ID, String PAN_NO, String MOBILE_NO, String IS_ACTIVE, String franchaices) {
        this.ID = ID;
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.LANG = LANG;
        this.LAT = LAT;
        this.GOOGLE_ID = GOOGLE_ID;
        this.VEG_ONLY = VEG_ONLY;
        this.IMG_URL = IMG_URL;
        this.START_TIME = START_TIME;
        this.END_TIME = END_TIME;
        this.DELIVER_IN = DELIVER_IN;
        this.MEAL_TYPE = MEAL_TYPE;
        this.CI_MA_ID = CI_MA_ID;
        this.RATTING = RATTING;
        this.REG_ID = REG_ID;
        this.PAN_NO = PAN_NO;
        this.MOBILE_NO = MOBILE_NO;
        this.IS_ACTIVE = IS_ACTIVE;
        this.franchaices = franchaices;
    }

    public User() {
    }

    @SerializedName("ID")
    private String ID;

    @SerializedName("NAME")
    private String NAME;

    @SerializedName("ADDRESS")
    private String ADDRESS;

    @SerializedName("LANG")
    private String LANG;

    @SerializedName("LAT")
    private String LAT;

    @SerializedName("GOOGLE_ID")
    private String GOOGLE_ID;

    @SerializedName("VEG_ONLY")
    private String VEG_ONLY;

    @SerializedName("IMG_URL")
    private String IMG_URL;

    @SerializedName("START_TIME")
    private String START_TIME;

    @SerializedName("END_TIME")
    private String END_TIME;

    @SerializedName("DELIVER_IN")
    private String DELIVER_IN;

    @SerializedName("MEAL_TYPE")
    private String MEAL_TYPE;

    @SerializedName("CI_MA_ID")
    private String CI_MA_ID;

    @SerializedName("RATTING")
    private String RATTING;

    @SerializedName("REG_ID")
    private String REG_ID;

    @SerializedName("PAN_NO")
    private String PAN_NO;

    @SerializedName("MOBILE_NO")
    private String MOBILE_NO;

    @SerializedName("IS_ACTIVE")
    private String IS_ACTIVE;

    @SerializedName("franchaices")
    private String franchaices;




}
