package com.hungry.hotel.hungryhoteladmin.orders.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;
import com.hungry.hotel.hungryhoteladmin.orders.model.Customer;
import com.hungry.hotel.hungryhoteladmin.orders.model.Hotel;
import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public LiveData<List<Order>> getOrders() {
        List<Order> orderList = new ArrayList<>();
        MutableLiveData<List<Order>> liveDataOrderList = new MutableLiveData<>();
//        Customer
        Customer customer = new Customer();
        customer.setCustomerName("Prasad Chawan");
        customer.setCustomerMobileNumber("8888888888");
        customer.setCustomerAddress("Ghorpade peth swar gate Mominpura Pune 411042");
//DeliveryBoy
        DeliveryBoy deliveryBoy = new DeliveryBoy();
        deliveryBoy.setDeliveryBoyName("Delivery Boy");
        deliveryBoy.setDeliveryBoyMobile("9999999999");
//        Hotel
        Hotel hotel = new Hotel();
        hotel.setHotelName("Hotel Royal");
//        Dishes
        Dish dish = new Dish();
        dish.setNAME("Sev Bhaji");
        dish.setAMOUNT("80.00");
        List<Dish> dishList = new ArrayList<>();
        dishList.add(dish);
        dishList.add(dish);
//        Order
        /*
        10-10
        Order order = new Order();
        order.setHotel(hotel);
        order.setNewOrder(true);
        order.setOrderImage("");
        order.setOrderDate("26 Nov 2019 11:55AM");
        order.setCustomer(customer);
        order.setCustomer(customer);
        order.setDeliveryBoy(deliveryBoy);
        order.setDishCount(3);
        order.setOrderStatus("NEW");
        order.setTotalPrice(300.00);
        order.setCommissionPercent(20);
        order.setCommission(15.00);
        order.setReceivableAmount(200.00);
        order.setOrderRating(3.5f);
        order.setDeliveryAddress("Ghorpade peth swar gate Mominpura Pune 411042");
        order.setDishList(dishList);
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);
        liveDataOrderList.setValue(orderList);
        */return liveDataOrderList;
    }
}
