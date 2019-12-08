package com.hungry.hotel.hungryhoteladmin.dashboard.model;

import android.os.Parcel;
import android.os.Parcelable;


public class OrderDashboard implements Parcelable {
    public static final String TOTAL_ORDER = "Total Order";
    public static final String NEW_ORDER = "New Order";
    public static final String ACCEPTED_ORDER = "Accpted";
    public static final String READY_ORDER = "Ready";
    public static final String REJECTED_ORDER = "Rejected Order";
    public static final String DELIVERED_ORDER = "Delivered Order";
    private int totalOrder;
    private String orderName;
    private double orderPrice;
    private boolean isNew;
    private int backgroundColor;


    public OrderDashboard() {
    }

    public OrderDashboard(int totalOrder, String orderName, double orderPrice, boolean isNew, int backgroundColor) {
        this.totalOrder = totalOrder;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.isNew = isNew;
        this.backgroundColor = backgroundColor;
    }

    protected OrderDashboard(Parcel in) {
        totalOrder = in.readInt();
        orderName = in.readString();
        orderPrice = in.readDouble();
        isNew = in.readByte() != 0;
        backgroundColor = in.readInt();
    }

    public static final Creator<OrderDashboard> CREATOR = new Creator<OrderDashboard>() {
        @Override
        public OrderDashboard createFromParcel(Parcel in) {
            return new OrderDashboard(in);
        }

        @Override
        public OrderDashboard[] newArray(int size) {
            return new OrderDashboard[size];
        }
    };

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalOrder);
        dest.writeString(orderName);
        dest.writeDouble(orderPrice);
        dest.writeByte((byte) (isNew ? 1 : 0));
        dest.writeInt(backgroundColor);
    }
}
