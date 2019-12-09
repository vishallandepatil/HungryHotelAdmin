package com.hungry.hotel.hungryhoteladmin.orders.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Order implements Parcelable {
    private int orderId;
    private boolean isNewOrder;
    private String orderImage;
    private String orderDate;
    private Customer customer;
    private List<Dish> dishList;
    private DeliveryBoy deliveryBoy;
    private int dishCount;
    private String orderStatus;
    private double totalPrice;
    private double commissionPercent;
    private double commission;
    private double receivableAmount;
    private float orderRating;
    private String deliveryAddress;
    private String orderFeedback;
    private Hotel hotel;


    public Order() {
    }

    protected Order(Parcel in) {
        orderId = in.readInt();
        isNewOrder = in.readByte() != 0;
        orderImage = in.readString();
        orderDate = in.readString();
        customer = in.readParcelable(Customer.class.getClassLoader());
        dishList = in.createTypedArrayList(Dish.CREATOR);
        deliveryBoy = in.readParcelable(DeliveryBoy.class.getClassLoader());
        dishCount = in.readInt();
        orderStatus = in.readString();
        totalPrice = in.readDouble();
        commissionPercent = in.readDouble();
        commission = in.readDouble();
        receivableAmount = in.readDouble();
        orderRating = in.readFloat();
        deliveryAddress = in.readString();
        orderFeedback = in.readString();
        hotel = in.readParcelable(Hotel.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(orderId);
        dest.writeByte((byte) (isNewOrder ? 1 : 0));
        dest.writeString(orderImage);
        dest.writeString(orderDate);
        dest.writeParcelable(customer, flags);
        dest.writeTypedList(dishList);
        dest.writeParcelable(deliveryBoy, flags);
        dest.writeInt(dishCount);
        dest.writeString(orderStatus);
        dest.writeDouble(totalPrice);
        dest.writeDouble(commissionPercent);
        dest.writeDouble(commission);
        dest.writeDouble(receivableAmount);
        dest.writeFloat(orderRating);
        dest.writeString(deliveryAddress);
        dest.writeString(orderFeedback);
        dest.writeParcelable(hotel, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public int getOrderId() {
        return orderId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(double commissionPercent) {
        this.commissionPercent = commissionPercent;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderFeedback() {
        return orderFeedback;
    }

    public void setOrderFeedback(String orderFeedback) {
        this.orderFeedback = orderFeedback;
    }
}
