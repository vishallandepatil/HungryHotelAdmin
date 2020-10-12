package com.hungry.hotel.hungryhoteladmin.restaurentmenu.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DishResponse  {

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Dish> getResult() {
        return result;
    }

    public void setResult(ArrayList<Dish> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("status")
    private int status;
    @SerializedName("count")
    private int count;
    @SerializedName("type")
    private String type;
    @SerializedName("result")
    public ArrayList<Dish> result;
    @SerializedName("message")
    private String message;


}
