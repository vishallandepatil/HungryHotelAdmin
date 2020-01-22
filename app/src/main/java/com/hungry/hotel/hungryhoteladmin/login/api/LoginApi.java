package com.hungry.hotel.hungryhoteladmin.login.api;

import com.hungry.hotel.hungryhoteladmin.login.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginApi {
    @GET("index.php/api/Hotels/authonticate")
    Call<Object> getLoginDetails(@Query("api_key") String apiKey, @Query("username") String userName,
                                   @Query("password") String password, @Query("partnertype") String loginType);

    @GET("index.php/api/Hotels/authonticate")
    Call<UserResponse> getLoginResponse(@Query("api_key") String apiKey, @Query("username") String userName,
                                        @Query("password") String password, @Query("partnertype") String loginType);
}
