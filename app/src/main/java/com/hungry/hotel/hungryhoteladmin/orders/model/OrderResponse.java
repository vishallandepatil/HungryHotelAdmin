package com.hungry.hotel.hungryhoteladmin.orders.model;

import com.google.gson.annotations.SerializedName;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.ArrayList;

public class OrderResponse {

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

    public ArrayList<Order> getResult() {
        return result;
    }

    public void setResult(ArrayList<Order> result) {
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
    public ArrayList<Order> result;
    @SerializedName("message")
    private String message;

    @Override
    public String toString() {
        return "OrderResponse{" +
                "status=" + status +
                ", count=" + count +
                ", type='" + type + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
