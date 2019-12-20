package com.example.dell.firstcry.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.dell.firstcry.Models.ManualRefreshModel;
import com.example.dell.firstcry.R;
import com.example.dell.firstcry.Static;

import static com.example.dell.firstcry.Static.SP;

public class SplashActivity extends AppCompatActivity implements SplashView{

    ManualRefreshModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_splash);


        SP = getSharedPreferences("Base_Preference", Context.MODE_PRIVATE);
        final String login_flag = SP.getString("login_state","false");

        new CountDownTimer(600,100){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent;
                if (login_flag.equals("true")){
                    Static.TOKEN = SP.getString("login_token",null);
                    model.performManualRefresh(Static.TOKEN);
                    intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    intent = new Intent(getApplicationContext(),LogInActivity.class);
                    startActivity(intent);finish();
                }
            }
        }.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        model = new ManualRefreshModel(this);
    }

    @Override
    public void dataLoadSuccess() {

    }

    @Override
    public void DataLoadFailed(String errorCode) {
        Toast.makeText(this,errorCode,Toast.LENGTH_SHORT).show();
    }
}
