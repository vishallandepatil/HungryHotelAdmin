package com.hungry.hotel.hungryhoteladmin.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit2;
    public static String API_KEY = "kjashdkahdkhaksjdhweshkhskjdhkj";

  //  private static final String BASE_URL = "";

    //private static final String BASE_URL = "http://bcsvirtual.com";
    private static final String BASE_URL = "http://hungryindia.co.in/index.php/api/";


    public static Retrofit getRetrofitInstanceServer() {
        if (retrofit2 == null) {
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }




}
