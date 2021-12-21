package com.example.retrfoit_json.Common;


import com.example.retrfoit_json.Interface.RetrofitService;
import com.example.retrfoit_json.Retrofit.RetrofitClient;

public class Common {
    private static final String BASE_URL = "https://raw.githubusercontent.com/fotehkamolov96/test/main/dn/";
    private static final String BASE_URL2 = "https://raw.githubusercontent.com/fotehkamolov96/test/main/dn/";

    public static RetrofitService getMovies() {
        return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);

    }

    public static RetrofitService getMovies2() {
        return RetrofitClient.getClient2(BASE_URL2).create(RetrofitService.class);
    }
}
