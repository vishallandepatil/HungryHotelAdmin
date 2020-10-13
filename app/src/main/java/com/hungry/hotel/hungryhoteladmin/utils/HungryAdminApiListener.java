package com.hungry.hotel.hungryhoteladmin.utils;

import retrofit2.Call;

public interface HungryAdminApiListener<T> {
    default void onSuccess(T t) {
    }

    void onFailure(double status, String message);
}
