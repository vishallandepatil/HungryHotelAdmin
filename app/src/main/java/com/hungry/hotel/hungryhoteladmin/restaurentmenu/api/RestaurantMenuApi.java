package com.hungry.hotel.hungryhoteladmin.restaurentmenu.api;

import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.Dish;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestaurantMenuApi {


//http://hungryindia.co.in/index.php/api/Hotels/menu?api_key=kjashdkahdkhaksjdhweshkhskjdhkj&TYPE=VEG&IS_SHOWN=Y&HOT_MA_ID=1    @FormUrlEncoded
    @GET("Hotels/menu")
    Call<DishResponse> getMenus (
            @Query("api_key") String api_key,
            @Query("TYPE") String TYPE,
            @Query("IS_SHOWN") String IS_SHOWN,
            @Query("HOT_MA_ID") int HOT_MA_ID
            // lang: eng/mar

    );

}
