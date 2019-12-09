package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {
    private int customerId;
    private String customerName;
    private String customerMobileNumber;
    private String customerAddress;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerMobileNumber, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobileNumber = customerMobileNumber;
        this.customerAddress = customerAddress;
    }

    protected Customer(Parcel in) {
        customerId = in.readInt();
        customerName = in.readString();
        customerMobileNumber = in.readString();
        customerAddress = in.readString();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(customerId);
        dest.writeString(customerName);
        dest.writeString(customerMobileNumber);
        dest.writeString(customerAddress);
    }
}
