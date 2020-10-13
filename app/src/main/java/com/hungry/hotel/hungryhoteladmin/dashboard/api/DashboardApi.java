package com.hungry.hotel.hungryhoteladmin.dashboard.api;

import com.hungry.hotel.hungryhoteladmin.dashboard.model.Dashboard;
import com.hungry.hotel.hungryhoteladmin.dashboard.model.DashboardResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DashboardApi {


//http://hungryindia.co.in/index.php/api/Order/Dashboard?api_key=kjashdkahdkhaksjdhweshkhskjdhkj&HOT_MS_ID=1&DL_BO_MA_ID=2
    @GET("Order/Dashboard")
    Call<DashboardResponse> getDashboardDetails(
            @Query("api_key") String api_key,
            @Query("HOT_MS_ID") String HOT_MS_ID,
            @Query("DL_BO_MA_ID") String DL_BO_MA_ID
    );


}
