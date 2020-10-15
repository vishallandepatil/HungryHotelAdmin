package com.hungry.hotel.hungryhoteladmin.profile.api;

import com.hungry.hotel.hungryhoteladmin.profile.model.IsActiveResponse;
import com.hungry.hotel.hungryhoteladmin.restaurentmenu.model.DishResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IsActiveApi {
    @FormUrlEncoded
    @PUT("Hotels/active")
    Call<IsActiveResponse> updateIsactive(
            @Field("api_key") String api_key,
            @Field("IS_ACTIVE") String IS_ACTIVE,
            @Field("DL_BO_MA_ID") String DL_BO_MA_ID
    );

}
