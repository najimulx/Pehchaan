package com.example.dell.firstcry.Objects;

public class UserProfileResponse {

    public String user,handle,name,location,status,bio,gender,age,disability,date;

    public UserProfileResponse(String user, String handle, String name, String location, String status,
                               String bio, String gender, String age, String disability, String date) {
        this.user = user;
        this.handle = handle;
        this.name = name;
        this.location = location;
        this.status = status;
        this.bio = bio;
        this.gender = gender;
        this.age = age;
        this.disability = disability;
        this.date = date;
    }

    public UserProfileResponse() {
    }
}