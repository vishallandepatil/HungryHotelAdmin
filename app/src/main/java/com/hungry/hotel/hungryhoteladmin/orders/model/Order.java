package com.hungry.hotel.hungryhoteladmin.orders.model;

import java.util.List;

public class Order {
    private int orderId;
    private Hotel hotel;
    private boolean isNewOrder;
    private String orderImage;
    private String orderDate;
    private Customer customer;
    private List<Dish> dishList;
    private DeliveryBoy deliveryBoy;
    private int dishCount;
    private String orderStatus;
    private double totalPrice;
    private double commission;
    private double receivableAmount;
    private float orderRating;

    public Order() {

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isNewOrder() {
        return isNewOrder;
    }

    public void setNewOrder(boolean newOrder) {
        isNewOrder = newOrder;
    }

    public String getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public DeliveryBoy getDeliveryBoy() {
        return deliveryBoy;
    }

    public void setDeliveryBoy(DeliveryBoy deliveryBoy) {
        this.deliveryBoy = deliveryBoy;
    }

    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(double receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public float getOrderRating() {
        return orderRating;
    }

    public void setOrderRating(float orderRating) {
        this.orderRating = orderRating;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
