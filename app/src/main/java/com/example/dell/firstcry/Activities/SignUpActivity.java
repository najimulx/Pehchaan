package com.example.dell.firstcry.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.firstcry.Models.SignupModel;
import com.example.dell.firstcry.R;

public class SignUpActivity extends Activity implements SignUpView{

    EditText et_email, et_pass1, et_pass2,et_name;
    ImageView tv_login;
    TextView bt_signup;
    SignupModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bt_signup = findViewById(R.id.bt_signup);
        et_email = findViewById(R.id.et_signup_email);
        et_pass1 = findViewById(R.id.et_signup_pass1);
        et_pass2 = findViewById(R.id.et_signup_pass2);
        tv_login = findViewById(R.id.tv_signup_login);
        et_name = findViewById(R.id.et_signup_name);
        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_pass1.getText().toString().equals(et_pass2.getText().toString())){
                    model.performSignup(et_name.getText().toString(),et_email.getText().toString(),et_pass1.getText().toString());
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void signupSuccess(String message) {
        Intent intent = new Intent(getApplicationContext(),LogInActivity.class);
        startActivity(intent);
        Log.i("SignUp","SignUp Success");
        finish();
    }

    @Override
    public void signupFailed(String errorCode) {
        Log.i("SignUp",errorCode);
    }

    @Override
    protected void onStart() {
        super.onStart();
        model = new SignupModel(this);
    }
}
