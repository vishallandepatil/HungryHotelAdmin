package com.hungry.hotel.hungryhoteladmin.orders.model;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerMobileNumber;
    private String customerAddress;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerMobileNumber, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobileNumber = customerMobileNumber;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
