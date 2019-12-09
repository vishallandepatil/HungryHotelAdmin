package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {
    private int dishId;
    private String dishName;
    private double dishPrice;

    public Dish() {
    }

    public Dish(int dishId, String dishName, double dishPrice) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    protected Dish(Parcel in) {
        dishId = in.readInt();
        dishName = in.readString();
        dishPrice = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dishId);
        dest.writeString(dishName);
        dest.writeDouble(dishPrice);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }
}
