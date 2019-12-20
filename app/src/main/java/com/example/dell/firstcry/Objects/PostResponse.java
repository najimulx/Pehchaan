package com.example.dell.firstcry.Objects;

import java.util.List;

public class PostResponse {

    public String _id,text,user,name,date,_v;

    public PostResponse() {
    }

    public PostResponse(String _id, String text,
                        String user, String name, String date, String _v) {
        this._id = _id;
        this.text = text;
        this.user = user;
        this.name = name;
        this.date = date;
        this._v = _v;

    }
}
