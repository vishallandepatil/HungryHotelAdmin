package com.hungry.hotel.hungryhoteladmin.deliveryboy.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hungry.hotel.hungryhoteladmin.deliveryboy.model.DeliveryBoy;

public class DeliveryBoyRepository {
    public LiveData<DeliveryBoy> getDeliveryBoyDetails() {
        DeliveryBoy deliveryBoy = new DeliveryBoy();
        MutableLiveData<DeliveryBoy> deliveryBoyMutableLiveData = new MutableLiveData<>();
        deliveryBoy.setDeliveryBoyId(1);
        deliveryBoy.setDeliveryBoyName("Mazhar");
        deliveryBoy.setDeliveryBoyAddress("Swargate mpominpura pune 411042");
        deliveryBoy.setDeliveryBoyMobile("9767572454");
        deliveryBoy.setFranchayName("Way to Store");
        deliveryBoy.setActivated(true);
        deliveryBoyMutableLiveData.setValue(deliveryBoy);
        return deliveryBoyMutableLiveData;


    }

}
