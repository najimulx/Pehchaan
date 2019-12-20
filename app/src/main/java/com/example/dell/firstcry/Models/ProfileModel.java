package com.example.dell.firstcry.Models;

import android.util.Log;

import com.example.dell.firstcry.Activities.ProfileView;
import com.example.dell.firstcry.Objects.LoginPostResponse;
import com.example.dell.firstcry.Objects.UserProfileResponse;
import com.example.dell.firstcry.RestApi.RetrofitClient;
import com.example.dell.firstcry.Static;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileModel {

    ProfileView view;

    public ProfileModel(ProfileView view) {
        this.view = view;
    }

    public void performGetProfile(String token){
        Call<UserProfileResponse> call = RetrofitClient.getInstance().getApi()
                .rest_get_userProfile("Bearer "+ token);
        call.enqueue(new Callback<UserProfileResponse>() {
            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                if (response.isSuccessful()){
                    view.success(response.body());
                }
                else{
                    view.failed("FAILED");
                }
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                view.failed(t.getMessage());
            }
        });
    }

    void performUpdateProfile(UserProfileResponse userProfileResponse){

    }

}
