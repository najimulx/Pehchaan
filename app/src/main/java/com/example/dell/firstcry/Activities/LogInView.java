package com.example.dell.firstcry.Activities;

import com.example.dell.firstcry.Objects.LoginPostResponse;

public interface LogInView {

    void loginSuccess(LoginPostResponse token);
    void loginFailed(String errorCode);
}
