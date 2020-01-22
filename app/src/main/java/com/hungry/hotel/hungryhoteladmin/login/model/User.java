package com.hungry.hotel.hungryhoteladmin.login.model;

import com.google.gson.annotations.SerializedName;

public class User {
    public static String ACCOUNT_TYPE = "Account Type";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }


    public String getDeliveryBoyMasterId() {
        return deliveryBoyMasterId;
    }

    public void setDeliveryBoyMasterId(String deliveryBoyMasterId) {
        this.deliveryBoyMasterId = deliveryBoyMasterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(String isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(String isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIsDocumentVerified() {
        return isDocumentVerified;
    }

    public void setIsDocumentVerified(String isDocumentVerified) {
        this.isDocumentVerified = isDocumentVerified;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getDrivingLicenceId() {
        return drivingLicenceId;
    }

    public void setDrivingLicenceId(String drivingLicenceId) {
        this.drivingLicenceId = drivingLicenceId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFranchicieId() {
        return franchicieId;
    }

    public void setFranchicieId(String franchicieId) {
        this.franchicieId = franchicieId;
    }

    public String getCityMasterId() {
        return cityMasterId;
    }

    public void setCityMasterId(String cityMasterId) {
        this.cityMasterId = cityMasterId;
    }

    public boolean isDeliveryBoy() {
        return isDeliveryBoy;
    }

    public void setDeliveryBoy(boolean deliveryBoy) {
        isDeliveryBoy = deliveryBoy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getVegOnly() {
        return vegOnly;
    }

    public void setVegOnly(String vegOnly) {
        this.vegOnly = vegOnly;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
    }

    public String getHotelStartTime() {
        return hotelStartTime;
    }

    public void setHotelStartTime(String hotelStartTime) {
        this.hotelStartTime = hotelStartTime;
    }

    public String getHotelEndTime() {
        return hotelEndTime;
    }

    public void setHotelEndTime(String hotelEndTime) {
        this.hotelEndTime = hotelEndTime;
    }

    public String getDeliverIn() {
        return deliverIn;
    }

    public void setDeliverIn(String deliverIn) {
        this.deliverIn = deliverIn;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getHotelCityMasterId() {
        return hotelCityMasterId;
    }

    public void setHotelCityMasterId(String hotelCityMasterId) {
        this.hotelCityMasterId = hotelCityMasterId;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String getHotelRegId() {
        return hotelRegId;
    }

    public void setHotelRegId(String hotelRegId) {
        this.hotelRegId = hotelRegId;
    }

    public String getHotelPanNo() {
        return hotelPanNo;
    }

    public void setHotelPanNo(String hotelPanNo) {
        this.hotelPanNo = hotelPanNo;
    }

    public String getHotelMobileNo() {
        return hotelMobileNo;
    }

    public void setHotelMobileNo(String hotelMobileNo) {
        this.hotelMobileNo = hotelMobileNo;
    }

    public String getFrenchies() {
        return frenchies;
    }

    public void setFrenchies(String frenchies) {
        this.frenchies = frenchies;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                ", otp='" + otp + '\'' +
                ", isDeliveryBoy=" + isDeliveryBoy +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", googleId='" + googleId + '\'' +
                ", vegOnly='" + vegOnly + '\'' +
                ", hotelImageUrl='" + hotelImageUrl + '\'' +
                ", hotelStartTime='" + hotelStartTime + '\'' +
                ", hotelEndTime='" + hotelEndTime + '\'' +
                ", deliverIn='" + deliverIn + '\'' +
                ", mealType='" + mealType + '\'' +
                ", hotelCityMasterId='" + hotelCityMasterId + '\'' +
                ", hotelRating='" + hotelRating + '\'' +
                ", hotelRegId='" + hotelRegId + '\'' +
                ", hotelPanNo='" + hotelPanNo + '\'' +
                ", hotelmobileNo='" + hotelMobileNo + '\'' +
                ", frenchies='" + frenchies + '\'' +
                ", deliveryBoyMasterId='" + deliveryBoyMasterId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", isMobileVerified='" + isMobileVerified + '\'' +
                ", isActive='" + isActive + '\'' +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", isEmailVerified='" + isEmailVerified + '\'' +
                ", aadharCard='" + aadharCard + '\'' +
                ", panCard='" + panCard + '\'' +
                ", img='" + img + '\'' +
                ", isDocumentVerified='" + isDocumentVerified + '\'' +
                ", voterId='" + voterId + '\'' +
                ", drivingLicenceId='" + drivingLicenceId + '\'' +
                ", lang='" + lang + '\'' +
                ", lat='" + lat + '\'' +
                ", franchicieId='" + franchicieId + '\'' +
                ", cityMasterId='" + cityMasterId + '\'' +
                '}';
    }
}
