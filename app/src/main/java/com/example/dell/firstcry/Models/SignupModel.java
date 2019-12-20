package com.example.dell.firstcry.Models;


import android.util.Log;

import com.example.dell.firstcry.Activities.SignUpView;
import com.example.dell.firstcry.RestApi.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupModel {

    SignUpView view;

    public SignupModel(SignUpView view) {
        this.view = view;
    }

    public void performSignup(String name,String email, String password){
        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().rest_register(name,email,password,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    view.signupSuccess(response.toString());
                }
                else{
                    view.signupFailed(response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                view.signupFailed("FAILED");
            }
        });


    }

}
