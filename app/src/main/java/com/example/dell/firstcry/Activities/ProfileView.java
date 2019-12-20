package com.example.dell.firstcry.Activities;

import com.example.dell.firstcry.Objects.UserProfileResponse;

public interface ProfileView {

    void success(UserProfileResponse userProfileResponse);
    void failed(String errorCode);

}
