package com.hungry.hotel.hungryhoteladmin.orders.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hungry.hotel.hungryhoteladmin.orders.model.Order;
import com.hungry.hotel.hungryhoteladmin.orders.repository.OrderRepository;

import java.util.List;

public class OrdersViewModel extends AndroidViewModel {

    public OrdersViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Order>> getOrderListObserver() {
        OrderRepository orderRepository = new OrderRepository();
        return orderRepository.getOrders();
    }
}
