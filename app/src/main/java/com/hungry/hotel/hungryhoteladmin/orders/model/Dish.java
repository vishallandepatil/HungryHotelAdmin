package com.hungry.hotel.hungryhoteladmin.orders.model;

public class Dish {
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
