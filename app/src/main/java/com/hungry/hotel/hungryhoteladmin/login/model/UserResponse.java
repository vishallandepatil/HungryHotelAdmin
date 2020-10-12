package com.hungry.hotel.hungryhoteladmin.login.model;

import com.google.gson.annotations.SerializedName;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.ArrayList;

public class UserResponse {


    @SerializedName("status")
    private int status;
    @SerializedName("count")
    private int count;
    @SerializedName("type")
    private String type;
    @SerializedName("result")
    public ArrayList<User> result;

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

    public ArrayList<User> getResult() {
        return result;
    }

    public void setResult(ArrayList<User> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    private String message;

    public UserResponse(int status, int count, String type, ArrayList<User> result, String message) {
        this.status = status;
        this.count = count;
        this.type = type;
        this.result = result;
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "status=" + status +
                ", count=" + count +
                ", type='" + type + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
