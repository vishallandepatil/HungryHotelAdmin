package com.hungry.hotel.hungryhoteladmin.orders.api;

import com.hungry.hotel.hungryhoteladmin.orders.model.OrderResponse;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OrderApi {

//http://hungryindia.co.in/index.php/api/Order/orders?
// api_key=kjashdkahdkhaksjdhweshkhskjdhkj&HOT_MS_ID=1&OR_STATUS=OPEN&CM_MS_ID=1
// &start=70&limit=6&DL_BO_MA_ID=2&DL_BOY_STATUS
    @GET("Order/orders")
    Call<OrderResponse> getOrder(
            @Query("api_key") String api_key,
            @Query("HOT_MS_ID") String HOT_MS_ID,
            @Query("OR_STATUS") String OR_STATUS,
            @Query("CM_MS_ID") String CM_MS_ID,
            @Query("start") String start,
            @Query("limit") String limit,
            @Query("DL_BO_MA_ID") String DL_BO_MA_ID,
            @Query("DL_BOY_STATUS") String DL_BOY_STATUS

    );

}
