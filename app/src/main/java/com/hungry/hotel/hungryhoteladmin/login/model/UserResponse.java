package com.hungry.hotel.hungryhoteladmin.login.model;

import com.google.gson.annotations.SerializedName;


import java.util.List;

public class UserResponse {
    @SerializedName("status")
    private double status;

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


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;

    }
}
