package com.hungry.hotel.hungryhoteladmin.restaurentmenu.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dish implements Parcelable {
    private int dishId;
    private String dishName;
    private double dishPrice;
    private boolean isShown;
    private String dishType;
    private int dishQuantity;
    private String dishDescription;
    private String dishCategory;
    private String dishStartTime;
    private String dishEndTime;


    public Dish() {
    }

    protected Dish(Parcel in) {
        dishId = in.readInt();
        dishName = in.readString();
        dishPrice = in.readDouble();
        isShown = in.readByte() != 0;
        dishType = in.readString();
        dishQuantity = in.readInt();
        dishDescription = in.readString();
        dishCategory = in.readString();
        dishStartTime = in.readString();
        dishEndTime = in.readString();
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

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public String getDishType() {
        return dishType;
    }

    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public int getDishQuantity() {
        return dishQuantity;
    }

    public void setDishQuantity(int dishQuantity) {
        this.dishQuantity = dishQuantity;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getDishCategory() {
        return dishCategory;
    }

    public void setDishCategory(String dishCategory) {
        this.dishCategory = dishCategory;
    }

    public String getDishStartTime() {
        return dishStartTime;
    }

    public void setDishStartTime(String dishStartTime) {
        this.dishStartTime = dishStartTime;
    }

    public String getDishEndTime() {
        return dishEndTime;
    }

    public void setDishEndTime(String dishEndTime) {
        this.dishEndTime = dishEndTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dishId);
        dest.writeString(dishName);
        dest.writeDouble(dishPrice);
        dest.writeByte((byte) (isShown ? 1 : 0));
        dest.writeString(dishType);
        dest.writeInt(dishQuantity);
        dest.writeString(dishDescription);
        dest.writeString(dishCategory);
        dest.writeString(dishStartTime);
        dest.writeString(dishEndTime);
    }
}
