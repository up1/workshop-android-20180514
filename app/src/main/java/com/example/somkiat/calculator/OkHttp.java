package com.example.somkiat.calculator;

import okhttp3.OkHttpClient;

public class OkHttp {

    private static OkHttpClient instance;

    public static OkHttpClient getInstance() {
        if(instance == null) {
            instance = new OkHttpClient();
        }
        return instance;
    }

}
