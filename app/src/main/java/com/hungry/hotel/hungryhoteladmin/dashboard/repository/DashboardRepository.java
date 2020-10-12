package com.hungry.hotel.hungryhoteladmin.dashboard.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hungry.hotel.hungryhoteladmin.dashboard.model.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class DashboardRepository {
    public LiveData<List<Dashboard>> getOrdersList() {
        List<Dashboard> orders = new ArrayList<>();
        MutableLiveData<List<Dashboard>> ordersDashboardLiveData = new MutableLiveData<>();

        /*10-10
        orders.add(new Dashboard(100, Dashboard.TOTAL_ORDER, 100.00, false));
        orders.add(new Dashboard(100, Dashboard.NEW_ORDER, 100.00, true));
        orders.add(new Dashboard(100, Dashboard.ACCEPTED_ORDER, 100.00, false));
        orders.add(new Dashboard(100, Dashboard.READY_ORDER, 100.00, false));
        orders.add(new Dashboard(100, Dashboard.REJECTED_ORDER, 100.00, false));
        orders.add(new Dashboard(100, Dashboard.DELIVERED_ORDER, 100.00, false));
        ordersDashboardLiveData.setValue(orders);*/
        return ordersDashboardLiveData;

    }
}
