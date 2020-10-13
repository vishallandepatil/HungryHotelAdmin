package com.hungry.hotel.hungryhoteladmin.menudetails.api;

import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface MenuDetailsApi {

    // http://hungryindia.co.in/index.php/api/Hotels/menu


        @FormUrlEncoded
        @POST("Hotels/menu")
        Call<DishResponse> addMenus(
            @Field("NAME") String NAME,
            @Field("AMOUNT") String AMOUNT,
            @Field("TYPE") String TYPE,
            @Field("QUNTITY") String QUNTITY,
            @Field("DESCRIPTION") String DESCRIPTION,
            @Field("CATEGORY") String CATEGORY,
            @Field("START_TIME") String START_TIME,
            @Field("END_TIME") String END_TIME,
            @Field("HOT_MA_ID") String HOT_MA_ID,
            @Field("ADDED_BY") String ADDED_BY,
            @Field("api_key") String api_key,
            @Field("IS_SHOWN") String IS_SHOWN,
            @Field("PRIORITY_ID") String PRIORITY_ID
            // lang: eng/mar
        );


        @FormUrlEncoded
        @PUT("Hotels/menu")
        Call<DishResponse> editMenus(
            @Field("NAME") String NAME,
            @Field("AMOUNT") String AMOUNT,
            @Field("TYPE") String TYPE,
            @Field("QUNTITY") String QUNTITY,
            @Field("DESCRIPTION") String DESCRIPTION,
            @Field("CATEGORY") String CATEGORY,
            @Field("START_TIME") String START_TIME,
            @Field("END_TIME") String END_TIME,
            @Field("HOT_MA_ID") String HOT_MA_ID,
            @Field("ADDED_BY") String ADDED_BY,
            @Field("api_key") String api_key,
            @Field("IS_SHOWN") String IS_SHOWN,
            @Field("MENU_MA_ID") String MENU_MA_ID,
            @Field("PRIORITY_ID") String PRIORITY_ID
            // lang: eng/mar
        );

}
