package com.hungry.hotel.hungryhoteladmin.orders.model;

public class DeliveryBoy {
    private int deliveryBoyId;
    private String deliveryBoyName;
    private String deliveryBoyMobile;

    public DeliveryBoy() {
    }

    public DeliveryBoy(int deliveryBoyId, String deliveryBoyName, String deliveryBoyMobile) {
        this.deliveryBoyId = deliveryBoyId;
        this.deliveryBoyName = deliveryBoyName;
        this.deliveryBoyMobile = deliveryBoyMobile;
    }

    public int getDeliveryBoyId() {
        return deliveryBoyId;
    }

    public void setDeliveryBoyId(int deliveryBoyId) {
        this.deliveryBoyId = deliveryBoyId;
    }

    public String getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(String deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
    }

    public String getDeliveryBoyMobile() {
        return deliveryBoyMobile;
    }

    public void setDeliveryBoyMobile(String deliveryBoyMobile) {
        this.deliveryBoyMobile = deliveryBoyMobile;
    }
}
