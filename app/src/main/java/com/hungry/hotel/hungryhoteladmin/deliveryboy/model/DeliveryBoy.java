package com.hungry.hotel.hungryhoteladmin.deliveryboy.model;

import android.os.Parcel;
import android.os.Parcelable;


public class DeliveryBoy implements Parcelable {
    private int deliveryBoyId;
    private String deliveryBoyName;
    private String deliveryBoyMobile;
    private String franchayName;
    private String deliveryBoyAddress;
    private boolean isActivated;

    public DeliveryBoy() {
    }

    protected DeliveryBoy(Parcel in) {
        deliveryBoyId = in.readInt();
        deliveryBoyName = in.readString();
        deliveryBoyMobile = in.readString();
        franchayName = in.readString();
        deliveryBoyAddress = in.readString();
        isActivated = in.readByte() != 0;
    }

    public static final Creator<DeliveryBoy> CREATOR = new Creator<DeliveryBoy>() {
        @Override
        public DeliveryBoy createFromParcel(Parcel in) {
            return new DeliveryBoy(in);
        }

        @Override
        public DeliveryBoy[] newArray(int size) {
            return new DeliveryBoy[size];
        }
    };

    public int getDeliveryBoyId() {
        return deliveryBoyId;
    }

    public void setDeliveryBoyId(int deliveryBoyId) {
        this.deliveryBoyId = deliveryBoyId;
    }

    public String getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(String deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
    }

    public String getDeliveryBoyMobile() {
        return deliveryBoyMobile;
    }

    public void setDeliveryBoyMobile(String deliveryBoyMobile) {
        this.deliveryBoyMobile = deliveryBoyMobile;
    }

    public String getFranchayName() {
        return franchayName;
    }

    public void setFranchayName(String franchayName) {
        this.franchayName = franchayName;
    }

    public String getDeliveryBoyAddress() {
        return deliveryBoyAddress;
    }

    public void setDeliveryBoyAddress(String deliveryBoyAddress) {
        this.deliveryBoyAddress = deliveryBoyAddress;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(deliveryBoyId);
        dest.writeString(deliveryBoyName);
        dest.writeString(deliveryBoyMobile);
        dest.writeString(franchayName);
        dest.writeString(deliveryBoyAddress);
        dest.writeByte((byte) (isActivated ? 1 : 0));
    }
}
