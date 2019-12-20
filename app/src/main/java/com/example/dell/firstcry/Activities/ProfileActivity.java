package com.example.dell.firstcry.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import com.example.dell.firstcry.Models.ProfileModel;
import com.example.dell.firstcry.Objects.UserProfileResponse;
import com.example.dell.firstcry.R;
import com.example.dell.firstcry.Static;

public class ProfileActivity extends AppCompatActivity implements ProfileView{
    ProfileModel model;

    TextView tv_profile_back,tv_profile_mobile,tv_profile_email,
            tv_profile_place, tv_profile_dob, tv_profile_gender,tv_profile_handle,tv_profile_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_profile_back = findViewById(R.id.tv_profile_back);
        tv_profile_dob = findViewById(R.id.tv_profile_dob);
        tv_profile_email = findViewById(R.id.tv_profile_email);
        tv_profile_gender = findViewById(R.id.tv_profile_gender);
        tv_profile_mobile = findViewById(R.id.tv_profile_phone);
        tv_profile_place = findViewById(R.id.tv_profile_location);
        tv_profile_handle = findViewById(R.id.tv_profile_handle);
        tv_profile_name = findViewById(R.id.tv_profile_name);
        tv_profile_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void success(UserProfileResponse userProfileResponse) {
        if (userProfileResponse.age != null && !userProfileResponse.age.equals("")){
            tv_profile_dob.setText(userProfileResponse.age);
        }
        if (userProfileResponse.bio != null && !userProfileResponse.bio.equals("")){

        }
        if (userProfileResponse.handle != null && !userProfileResponse.handle.equals("")){
            tv_profile_handle.setText(userProfileResponse.handle);
        }
        if (userProfileResponse.location != null && !userProfileResponse.location.equals("")){
            tv_profile_place.setText(userProfileResponse.location);
        }
        if (userProfileResponse.gender != null && !userProfileResponse.gender.equals("")){
            tv_profile_gender.setText(userProfileResponse.gender);
        }
        if (userProfileResponse.name != null && !userProfileResponse.name.equals("")){
            tv_profile_name.setText(userProfileResponse.name);
        }
    }

    @Override
    public void failed(String errorCode) {
        Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
        Log.i("PROFILE",errorCode);
    }

    @Override
    protected void onStart() {
        super.onStart();
        model = new ProfileModel(this);
        model.performGetProfile(Static.TOKEN);

    }
}
