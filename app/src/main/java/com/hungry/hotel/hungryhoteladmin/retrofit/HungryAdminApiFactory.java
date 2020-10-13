package com.hungry.hotel.hungryhoteladmin.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HungryAdminApiFactory {
    public static final String PROD_URL = "http://hungryindia.co.in/";
    public static final String TEST_URL = "http://hungryindia.co.in/";
    public static final String API_KEY = "kjashdkahdkhaksjdhweshkhskjdhkj";

    private static Retrofit retrofit = null;


    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(TEST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
