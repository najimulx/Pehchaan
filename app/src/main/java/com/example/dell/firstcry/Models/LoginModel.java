package com.example.dell.firstcry.Models;


import com.example.dell.firstcry.Activities.LogInView;
import com.example.dell.firstcry.Objects.LoginPostResponse;
import com.example.dell.firstcry.RestApi.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel {

    LogInView view;

    public LoginModel(LogInView view) {
        this.view = view;
    }

    public void performLogin(String email, String password){
        Call<LoginPostResponse> call = RetrofitClient.getInstance().getApi().rest_login(email,password);
        call.enqueue(new Callback<LoginPostResponse>() {
            @Override
            public void onResponse(Call<LoginPostResponse> call, Response<LoginPostResponse> response) {
                if (response.isSuccessful()){
                    view.loginSuccess(response.body());
                }
                else{
                    view.loginFailed(response.toString());
                }
            }

            @Override
            public void onFailure(Call<LoginPostResponse> call, Throwable t) {
                view.loginFailed("FAILED");
            }
        });
    }

}
