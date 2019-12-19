package com.hungry.hotel.hungryhoteladmin.dashboard.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;

import java.util.ArrayList;
import java.util.List;

public class DashboardRepository {
    public LiveData<List<OrderDashboard>> getOrdersList() {
        List<OrderDashboard> orders = new ArrayList<>();
        MutableLiveData<List<OrderDashboard>> ordersDashboardLiveData = new MutableLiveData<>();

        orders.add(new OrderDashboard(100, OrderDashboard.TOTAL_ORDER, 100.00, false));
        orders.add(new OrderDashboard(100, OrderDashboard.NEW_ORDER, 100.00, true));
        orders.add(new OrderDashboard(100, OrderDashboard.ACCEPTED_ORDER, 100.00, false));
        orders.add(new OrderDashboard(100, OrderDashboard.READY_ORDER, 100.00, false));
        orders.add(new OrderDashboard(100, OrderDashboard.REJECTED_ORDER, 100.00, false));
        orders.add(new OrderDashboard(100, OrderDashboard.DELIVERED_ORDER, 100.00, false));
        ordersDashboardLiveData.setValue(orders);
        return ordersDashboardLiveData;

    }
}
