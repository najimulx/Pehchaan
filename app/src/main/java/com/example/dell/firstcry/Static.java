package com.example.dell.firstcry;

import android.content.SharedPreferences;

import com.example.dell.firstcry.Objects.BannerResponse;
import com.example.dell.firstcry.Objects.InfoResponse;
import com.example.dell.firstcry.Objects.PostResponse;

import java.util.List;

public class Static {

    public static SharedPreferences SP = null;
    public static String REST_BASE_URL = "https://pehchaansi.herokuapp.com/";
    public static String REST_BASE_URL2 = "http://scrapeschema.herokuapp.com/";
    public static String TOKEN = null;
    public static List<BannerResponse> BANNER_OBJECT_LIST = null;
    public static List<PostResponse> POST_OBJECT_LIST = null;
    public static List<InfoResponse> INFO_OBJECT_LIST = null;

}
