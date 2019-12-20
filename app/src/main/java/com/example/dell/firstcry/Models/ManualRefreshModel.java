package com.example.dell.firstcry.Models;

import android.util.Log;

import com.example.dell.firstcry.Activities.SplashView;
import com.example.dell.firstcry.Objects.BannerResponse;
import com.example.dell.firstcry.Objects.InfoResponse;
import com.example.dell.firstcry.Objects.PostResponse;
import com.example.dell.firstcry.RestApi.RetrofitClient;
import com.example.dell.firstcry.RestApi.RetrofitClient2;
import com.example.dell.firstcry.Static;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManualRefreshModel {

    SplashView view;

    public ManualRefreshModel(SplashView view) {
        this.view = view;
    }
    public ManualRefreshModel(){}

    public void performManualRefresh(String token){
        //BANNER
        Call<List<BannerResponse>> call = RetrofitClient.getInstance().getApi()
                .rest_get_event("Bearer "+ token);
        call.enqueue(new Callback<List<BannerResponse>>() {
            @Override
            public void onResponse(Call<List<BannerResponse>> call, Response<List<BannerResponse>> response) {
                if (response.isSuccessful()){
                    Static.BANNER_OBJECT_LIST = response.body();
                }
                else{
                }
            }

            @Override
            public void onFailure(Call<List<BannerResponse>> call, Throwable t) {
            }
        });

        //POST
        Call<List<PostResponse>> call1 = RetrofitClient.getInstance().getApi()
                .rest_get_post("Bearer "+ token);
        call1.enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                if (response.isSuccessful()){
                    Static.POST_OBJECT_LIST = response.body();
                }
                else{
                    Log.i("DATA_TEST","FAILED");
                }
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
                Log.i("DATA_TEST",t.getMessage());
            }
        });

        //INFO
        Call<List<InfoResponse>> call3 = RetrofitClient2.getInstance().getApi()
                .rest_get_info();//"Bearer "+ token
        call3.enqueue(new Callback<List<InfoResponse>>() {
            @Override
            public void onResponse(Call<List<InfoResponse>> call, Response<List<InfoResponse>> response) {
                if (response.isSuccessful()){
                    Static.INFO_OBJECT_LIST = response.body();
                }
                else{
                }
            }

            @Override
            public void onFailure(Call<List<InfoResponse>> call, Throwable t) {
            }
        });
    }




}
