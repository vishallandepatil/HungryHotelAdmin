package com.hungry.hotel.hungryhoteladmin.login.api;

import com.hungry.hotel.hungryhoteladmin.login.model.DeliveryBoyResponse;
import com.hungry.hotel.hungryhoteladmin.login.model.UserResponse;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginApi {



//http://hungryindia.co.in/index.php/api/Hotels/authonticate?username=vishall&password=Vishal@123&
// partnertype=HOTEL&api_key=kjashdkahdkhaksjdhweshkhskjdhkj
    @GET("Hotels/authonticate")
    Call<UserResponse> checkLogin(
            @Query("username") String username,
            @Query("password") String password,
            @Query("partnertype") String partnertype,
            @Query("api_key") String api_key
            // lang: eng/mar

    );

    @GET("Hotels/authonticate")
    Call<DeliveryBoyResponse> checkDBLogin(
            @Query("username") String username,
            @Query("password") String password,
            @Query("partnertype") String partnertype,
            @Query("api_key") String api_key
            // lang: eng/mar

    );


}
