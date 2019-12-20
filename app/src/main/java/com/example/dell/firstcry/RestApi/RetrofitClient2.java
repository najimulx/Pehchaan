package com.example.dell.firstcry.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.dell.firstcry.Static.REST_BASE_URL;
import static com.example.dell.firstcry.Static.REST_BASE_URL2;

public class RetrofitClient2 {
    String baseURL = REST_BASE_URL2;
    private static RetrofitClient2 mInstance;
    private Retrofit retrofit;

    private RetrofitClient2() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient2 getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient2();
        }
        return mInstance;
    }

    public MyRestApi getApi(){
        return retrofit.create(MyRestApi.class);
    }
}
