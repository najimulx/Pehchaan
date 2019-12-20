package com.example.dell.firstcry.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.firstcry.Models.LoginModel;
import com.example.dell.firstcry.Objects.LoginPostResponse;
import com.example.dell.firstcry.R;

import static com.example.dell.firstcry.Static.SP;

public class LogInActivity extends Activity implements LogInView {

    EditText et_login_email, et_login_password;
    TextView bt_login;
    LoginModel model;
    TextView tv_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        bt_login = findViewById(R.id.bt_login);
        et_login_email = findViewById(R.id.et_login_email);
        et_login_password = findViewById(R.id.et_login_password);
        tv_signup = findViewById(R.id.tv_login_signup);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.performLogin(et_login_email.getText().toString(),et_login_password.getText().toString());
            }
        });
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void loginSuccess(LoginPostResponse token) {
        SP.edit().putString("login_state","true").apply();
        SP.edit().putString("login_token",token.token).apply();
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFailed(String errorCode) {
        Toast.makeText(this,errorCode, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        model = new LoginModel(this);
    }

}
