package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;


public class DeliveryBoy implements Parcelable {
    private int deliveryBoyId;
    private String deliveryBoyName;
    private String deliveryBoyMobile;

    public DeliveryBoy() {
    }

    public DeliveryBoy(int deliveryBoyId, String deliveryBoyName, String deliveryBoyMobile) {
        this.deliveryBoyId = deliveryBoyId;
        this.deliveryBoyName = deliveryBoyName;
        this.deliveryBoyMobile = deliveryBoyMobile;
    }

    protected DeliveryBoy(Parcel in) {
        deliveryBoyId = in.readInt();
        deliveryBoyName = in.readString();
        deliveryBoyMobile = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(deliveryBoyId);
        dest.writeString(deliveryBoyName);
        dest.writeString(deliveryBoyMobile);
    }
}
