package com.hungry.hotel.hungryhoteladmin.login.repository;


import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hungry.hotel.hungryhoteladmin.login.api.LoginApi;
import com.hungry.hotel.hungryhoteladmin.login.model.User;
import com.hungry.hotel.hungryhoteladmin.login.model.UserResponse;
import com.hungry.hotel.hungryhoteladmin.retrofit.HungryAdminApiFactory;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminApiListener;
import com.hungry.hotel.hungryhoteladmin.utils.HungryAdminUtility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginRepository {

    public void getUser(User user, HungryAdminApiListener apiListener) {
        String accountType = getAccountType(user);
        LoginApi loginApi = HungryAdminApiFactory.getInstance().create(LoginApi.class);
        Call<UserResponse> dataCall = loginApi.getLoginResponse(HungryAdminApiFactory.API_KEY,
                user.getUserName(), user.getPassword(), accountType);
        dataCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d("login_response", response.toString());
                if (response.body().getStatus() == 200) {
                    apiListener.onSuccess(response.body().getUsers().get(0));
                } else {
                    apiListener.onFailure(response.body().getStatus(), response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("login_failure", t.getMessage());
                apiListener.onFailure(0, "Something went wrong");
            }
        });


//        return null;

    }

    private String getAccountType(User user) {
        String accountType = "";
        if (!HungryAdminUtility.isNullOrEmpty(user.getAccountType())) {
            if (user.getAccountType().equalsIgnoreCase(User.DELIVERY_BOY))
                accountType = "DELIVERYBOY";
            if (user.getAccountType().equalsIgnoreCase(User.HOTEL_ADMIN))
                accountType = "HOTEL";
        }
        return accountType;
    }

    public boolean saveUser(User user) {
        return false;
    }
}
