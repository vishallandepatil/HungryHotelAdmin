package com.hungry.hotel.hungryhoteladmin.dashboard.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hungry.hotel.hungryhoteladmin.dashboard.model.OrderDashboard;
import com.hungry.hotel.hungryhoteladmin.dashboard.repository.DashboardRepository;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {
    public DashboardViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<OrderDashboard>> getOrdersList() {
        DashboardRepository dashboardRepository = new DashboardRepository();
        return dashboardRepository.getOrdersList();
    }
}
