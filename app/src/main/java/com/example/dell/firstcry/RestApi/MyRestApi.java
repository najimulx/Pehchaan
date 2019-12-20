package com.example.dell.firstcry.RestApi;

import com.example.dell.firstcry.Objects.BannerResponse;
import com.example.dell.firstcry.Objects.InfoResponse;
import com.example.dell.firstcry.Objects.LoginPostResponse;
import com.example.dell.firstcry.Objects.PostResponse;
import com.example.dell.firstcry.Objects.UserProfileResponse;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MyRestApi {

    @FormUrlEncoded
    @POST("api/register")
    Call<ResponseBody> rest_register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password2") String password2
    );

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginPostResponse> rest_login(
            @Field("email") String email,
            @Field("password") String password
    );
    @GET("api/profile")
    Call<UserProfileResponse> rest_get_userProfile(
            @Header("authorization") String token
    );
    @GET("api/event")
    Call<List<BannerResponse>> rest_get_event(
            @Header("authorization") String token
    );
    @GET("api/posts")
    Call<List<PostResponse>> rest_get_post(
            @Header("authorization") String token
    );

    @FormUrlEncoded
    @POST("api/posts")
    Call<ResponseBody> rest_create_post(
            @Field("text") String text,
            @Header("authorization") String token
    );
    @GET("scrape")
    Call<List<InfoResponse>> rest_get_info(
    );

}
